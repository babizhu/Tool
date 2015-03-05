package com.bbz.tool.common;

import org.hamcrest.Matchers;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.assertEquals;


/**
 * user         LIUKUN
 * com.bbz.com.bbz.tool.time         2014-4-9 13:19
 */

public class RandomUtilTest{
    @Test
    public void testGetInt() throws Exception{
        System.out.println( RandomUtil.getInt( 100 ) );

    }

    @Test
    public void testGetInt1() throws Exception{
        int num;
        for( int i = 0; i < 100; i++ ) {

            num = RandomUtil.getRange( 1, 2 );
            assertEquals( 1, num );
        }
        Integer min = 2;
        int max = 10;
        for( int i = 0; i < 1000; i++ ) {

            num = RandomUtil.getRange( min, max );
            assertThat( num, Matchers.allOf( greaterThanOrEqualTo( min ), lessThan( max ) ) );
        }

    }


    @Test
    public void testGetInt2() throws Exception{

    }

    @Test
    public void testGetInt3() throws Exception{

    }

    @Test
    public void testIsHappen() throws Exception{
        boolean happen = RandomUtil.isHappen( 100 );
        assertEquals( true, happen );

        happen = RandomUtil.isHappen( -100 );
        assertEquals( false,happen );

        happen = RandomUtil.isHappen( -0.1f );
        assertEquals( false,happen );



    }

    @Test
    public void testMain() throws Exception{

    }
}
