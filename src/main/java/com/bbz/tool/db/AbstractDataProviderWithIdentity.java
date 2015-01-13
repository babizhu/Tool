package com.bbz.tool.db;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.mongodb.*;

import java.util.List;
import java.util.Map;

/**
 * user         LIUKUN
 *     14-3-27 下午3:51
 * <p/>
 * 负责处理具有唯一id的实体类,构造函数包括2个，一个用户名，一个表名
 * 通常一个玩家会有多条记录，比如英雄表
 *
 * 注意：重载encode()的方法时，不需要显式指定uname，add()方法会自动处理
 */
@SuppressWarnings("UnusedDeclaration")
public abstract class AbstractDataProviderWithIdentity<T extends IdentityObj>{
    private final String        uname;
    private final DBCollection  collection;

    /**
     * @param tableName 要处理的表名
     * @param uname     玩家名称
     */
    public AbstractDataProviderWithIdentity( String tableName, String uname ){
        this.uname = uname;
        collection = MongoUtil.INSTANCE.getDB().getCollection( tableName );
    }

    protected abstract T decode( DBObject obj );

    protected abstract DBObject encode( T t );

    public T findOne( DBObject condition ){
        return decode( collection.findOne( condition ) );
    }

    public List<T> findBy( String key, Object content ){
        BasicDBObject condition = new BasicDBObject( "uname", uname );
        condition.append( key, content );
        return findBy( condition );
    }

    public List<T> findBy( DBObject condition ){
        List<T> list = Lists.newArrayList();

        DBCursor cursor = collection.find( condition );
        while( cursor.hasNext() ) {
            list.add( decode( cursor.next() ) );
        }
        return list;
    }

    public void add( T t ){
        DBObject obj = encode( t );
        obj.put( "uname", getUname() );
        collection.insert( obj );
    }

    /**
     * 返回一个list，查询条件为玩家名
     */
    public List<T> getListAll(){
        List<T> list = Lists.newArrayList();

        BasicDBObject condition = new BasicDBObject( "uname", uname );

        try( DBCursor cursor = collection.find( condition ) ) {
            while( cursor.hasNext() ) {
//            cursor.next();
                list.add( decode( cursor.next() ) );
            }
        }
        return list;
    }

    /**
     * 返回一个list，传入查询条件，会默认添加玩家名条件
     * @param conditions 传入条件
     * @return List<T>
     */
    public List<T> getListAllBy(BasicDBObject conditions){
        List<T> list = Lists.newArrayList();

        conditions.append("uname", uname);

        try( DBCursor cursor = collection.find( conditions ) ) {
            while( cursor.hasNext() ) {
//            cursor.next();
                list.add( decode( cursor.next() ) );
            }
        }
        return list;
    }

    /**
     * 以id为key返回一个hashmap，传入查询条件，会默认添加玩家名条件
     * @param conditions 传入条件
     * @return Map
     */
    public Map<Long, T> getMapAllBy(BasicDBObject conditions){
        Map<Long, T> map = Maps.newHashMap();

        conditions.append("uname", uname);

        try( DBCursor cursor = collection.find( conditions ) ) {
            while( cursor.hasNext() ) {
                T t = decode( cursor.next() );
//            cursor.next();

                map.put( t.getId(), t );
            }
        }
        return map;
    }

    /**
     * 以id为key返回一个hashmap，查询条件为玩家名
     *
     */
    public Map<Long, T> getMapAll(){
        Map<Long, T> map = Maps.newHashMap();

        BasicDBObject condition = new BasicDBObject( "uname", uname );

        try( DBCursor cursor = collection.find( condition ) ) {
            while( cursor.hasNext() ) {
                T t = decode( cursor.next() );
//            cursor.next();

                map.put( t.getId(), t );
            }
        }
        return map;
    }

    public void remove( IdentityObj obj ){
        DBObject conditon = new BasicDBObject( "_id", obj.getId() );
        collection.remove( conditon );
    }

    /**
     * 传统数据库的update，如果不存在查询条件所指定的记录，那么是不会主动insert记录的
     * @param t     要更新的内容
     */
    public void update( T t ){
        DBObject conditon = new BasicDBObject( "_id", t.getId() );
        DBObject obj = encode( t );
        obj.put( "uname", getUname() );
        collection.update( conditon, obj );
    }

    /**
     * 更新一个对象的某个字段
     *
     * @param t          要更新的对象
     * @param fieldName  要更新的列名
     * @param fieldValue 要更新的内容
     */
    public void updateWithField( T t, String fieldName, Object fieldValue ){
        BasicDBObject condition = new BasicDBObject( "_id", t.getId() );
        BasicDBObject updateField = new BasicDBObject( "$set", new BasicDBObject( fieldName, fieldValue ) );
        //collection.updateMulti( condition, updateField );
        collection.update( condition, updateField );
    }

    /**
     * 删除玩家此表下的所有数据
     */
    public void removeAll(){
        DBObject conditon = new BasicDBObject( "uname", uname );
        collection.remove( conditon );
    }

//    /**
//     * 删除表中所有的数据
//     * 慎用！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！
//     */
//    public void drop(){
//        collection.drop();
//    }

    /**
     * 如果数据库存在此数据("_id"为标准)，则更新此数据，否则添加此数据
     *
     * @param t 要更新的数据
     * @return true:替换</br>
     * false:插入
     */
    public boolean replace( T t ){
        WriteResult save = collection.save( encode( t ) );
        return (Boolean) save.getField( "updatedExisting" );
    }

    public String getUname(){
        return uname;
    }

    public DBCollection getCollection(){
        return collection;
    }
}
