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
}