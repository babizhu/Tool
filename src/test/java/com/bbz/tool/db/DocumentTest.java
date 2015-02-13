package com.bbz.tool.db;

import com.google.common.collect.Lists;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import org.junit.Test;

import java.util.List;

/**
 * user         LIUKUN
 * time         2015-1-19 17:54
 */

public class DocumentTest{
    private static final String TABLE_NAME = "MongoUtilTest";
    private static final DBCollection collection = MongoUtil.INSTANCE.getDB().getCollection( TABLE_NAME );

    @Test
    public void testAdd() throws Exception{
        collection.drop();

        List<Stuff> list = Lists.newArrayList();
        int count = 100;
        for( int i = 0; i < count; i++ ) {
            Stuff st = new Stuff();
            st.setId( i );
            st.setPower( i*100 );
            st.setTempletId( i*10 );
            list.add( st );

        }


        BasicDBObject dBObject = new BasicDBObject();
        for( Stuff stuff : list ) {

            DBObject object = new BasicDBObject(  );
            dBObject.append( "power", stuff.getPower() );
            dBObject.append( "tid", stuff.getTempletId() );

        }
        collection.insert(  dBObject ) ;

    }
}
