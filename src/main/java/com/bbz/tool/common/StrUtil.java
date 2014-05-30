package com.bbz.tool.common;

/**
 * user         LIUKUN
 * time         2014-5-30 14:29
 * 字符串的一些工具类<br/>
 * 为了避免混淆，没有取名StringUtil
 */

public class StrUtil{

    private StrUtil(){
    }

    /**
     * 把首字母变成大写<p/>
     *
     * @param str 输入的字符串
     * @return 首字母大写的字符串
     * <p/>
     * <p/>
     * 如果输入字符串为null或者空字符，则原样返回
     */
    public static String firstCharacterToUpper( String str ){
        if( str == null ) {
            throw new IllegalArgumentException();
        }
        if( str.isEmpty() ) {
            return str;
        }
        if( Character.isUpperCase( str.charAt( 0 ) ) ) {
            return str;
        }
        return (new StringBuilder())
                .append( Character.toUpperCase( str.charAt( 0 ) ) )
                .append( str.substring( 1 ) )
                .toString();

    }
}
