package com.bbz.tool.common;

import com.google.common.collect.Maps;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.assertEquals;

public class CountMapTest{
    @Test
    public void testPut() throws Exception{
        String name = "lk";
        CountMap<String> countMap = new CountMap<>();
        assertEquals( true, countMap.isEmpty() );
        assertEquals( 0, countMap.size() );
        countMap.put( name, 1 );
        countMap.clear();
        assertEquals( 0, countMap.size() );

        countMap.add( name, 3 );
        countMap.add( name, 20 );
        int count = countMap.get( name );
        assertEquals( 23, count );

        count = countMap.add( name, 40 );
        assertEquals( 63, count );

        for( String s : countMap.keySet() ) {
            System.out.println( s );
        }

        for( Integer integer : countMap.values() ) {
            System.out.println( integer );
        }

        for( Map.Entry<String, Integer> entry : countMap.entrySet() ) {
            System.out.println( entry.getKey() + ":" + entry.getValue() );
        }


        assertEquals( true, countMap.containsKey( name ) );

        countMap.remove( name );

    }

    @Test
    public void testAddAll() throws Exception{
        String name = "lk";
        Map<String, Integer> map = Maps.newHashMap();
        map.put( name, 100 );

        CountMap<String> countMap = new CountMap<>();
        countMap.put( name, 200 );
        countMap.addAll( map );
        int count = countMap.get( name );
        assertEquals( 300, count );
    }
}