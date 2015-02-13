package com.bbz.tool.identity;

import junit.framework.TestCase;

public class IdentityUtilTest extends TestCase{

    public void testGetMaxId() throws Exception{

        System.out.println(IdentityUtil.getMaxId( "hero" ) );

    }
}