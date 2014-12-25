package com.bbz.tool.db;


import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import org.junit.Test;

/**
 * user         LIUKUN
 * com.bbz.com.bbz.tool.time         2014-4-14 16:19
 */

public class MongoUtilTest{
    private static final String TABLE_NAME = "MongoUtilTest";
    private static final DBCollection collection = MongoUtil.INSTANCE.getDB().getCollection( TABLE_NAME );

    @Test
    public void testAdd() throws Exception{
        collection.drop();
        long begin = System.nanoTime();
        for( int i = 0; i < 10000; i++ ) {
            collection.insert( new BasicDBObject( "a" + i, "hellooooooooooooooooooooooo" + i ) );
        }
        System.out.println( "操作耗时：" + (System.nanoTime() - begin) / 1000000000f + "秒" );

    }

    /**
     * 结论：不行mongo 无法序列化自定义类
     *
     * @throws Exception
     */
    @Test
    public void testSaveObject() throws Exception{

    }

}
