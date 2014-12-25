package com.bbz.tool.identity;

import com.bbz.tool.db.MongoUtil;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;

/**
 * user         LIUKUN
 * com.bbz.com.bbz.tool.com.bbz.com.bbz.tool.time         2014-3-28 17:19
 */

enum IdentityDataProvider{
    INSTANCE;

    private final String TABLE_NAME = "global_identity";
    private final String ID_FIELD = "i";
    private DBCollection collection = MongoUtil.INSTANCE.getDB().getCollection( TABLE_NAME );
    
    public long get(){
        DBObject object = collection.findOne();
        if( object == null ){
            return  0;
        }
        return (Long) object.get( "id" );
    }
    
    public void set( long id ){
        DBObject obj = new BasicDBObject( "id", id ).append( "_id", ID_FIELD );
        collection.save( obj );
    }
}
