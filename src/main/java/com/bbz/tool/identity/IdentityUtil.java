package com.bbz.tool.identity;

import com.bbz.tool.db.MongoUtil;
import com.mongodb.*;


/**
 * user         LIUKUN
 * time         2015-2-9 12:15
 */

public class IdentityUtil{
    static long getMaxId( String tableName ){
        DBCollection collection = MongoUtil.INSTANCE.getDB().getCollection( tableName );

//        QueryBuilder query = new QueryBuilder();
//        query.s
//        query.or( new BasicDBObject( "name", "bbz1" ), new BasicDBObject( "times", 5 ) );
//        // query.and( "id" ).is( 2 );
//        try( DBCursor cursor = coll.find( query.get() ).addSpecial( "$returnKey", "" ) ) {
//            while( cursor.hasNext() ) {
//                System.out.println( cursor.next() );
//            }
//        }
//
//        Query q = new BasicQuery("{}").with(new Sort(new Sort.Order(Sort.Direction.ASC, "age"))).limit(1);
//        Person result = mongoTemplate.findOne(q, Person.class);


        DBCursor cursor = collection.find( null, new BasicDBObject( "_id", 1 ) )
                .sort( new BasicDBObject( "_id", -1 ) ).limit( 1 );
        if( cursor.hasNext() ) {
            DBObject next = cursor.next();
            //System.out.println( next.get( "_id" ) + ":" + next.get( "uname" ) + ":" + next.get( "position" ) );
            return Long.parseLong( next.get( "_id" ).toString() );
        }
        return 1;
    }
}
