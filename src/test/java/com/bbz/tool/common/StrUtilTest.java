package com.bbz.tool.common;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StrUtilTest{

    @Test
    public void testFirstCharacterToUpper() throws Exception{
        String str = "test";
        assertEquals( "Test", StrUtil.firstCharacterToUpper( str ) );

        str = "Test";
        assertEquals( "Test", StrUtil.firstCharacterToUpper( str ) );

        str = "";
        assertEquals( "", StrUtil.firstCharacterToUpper( str ) );

//        str = null;
//        assertEquals( str, StrUtil.firstCharacterToUpper( str ) );

    }

    @Test
    public void testFirstCharacterToLower() throws Exception{
        String str = "test";
        assertEquals( "test", StrUtil.firstCharacterToLower( str ) );

        str = "Test";
        assertEquals( "test", StrUtil.firstCharacterToLower( str ) );

        str = "";
        assertEquals( "", StrUtil.firstCharacterToLower( str ) );

//        str = null;
//        assertEquals( str, StrUtil.firstCharacterToUpper( str ) );

    }

    @Test
    public void testRemoveLastChar(){
        String str = "test";
        assertEquals( "tes", StrUtil.removeLastChar( str ) );

        str = "";
        assertEquals( "", StrUtil.removeLastChar( str ) );

        str = null;
        assertEquals( null, StrUtil.removeLastChar( str ) );
    }


}