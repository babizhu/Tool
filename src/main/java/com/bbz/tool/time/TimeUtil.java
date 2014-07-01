package com.bbz.tool.time;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 * user         LIUKUN
 * 2014-4-28 17:30
 */

/**
 * 时间相关的工具类
 */
public class TimeUtil{

    public static final String DATA_FORMAT_STR = "yyyy-MM-dd HH:mm:ss";
    private static final DateTimeFormatter DATA_PATTERN = DateTimeFormat.forPattern( "yyyy-MM-dd HH:mm:ss" );
    /**
     * 判断输入的时间点是否今天
     *
     * @param time 用秒为单位表述的一个时间点
     * @return true     是今天
     */
    public static boolean isToday( int time ){
        LocalDate compare = new LocalDate( time * 1000L );
        return new LocalDate().equals( compare );
    }

    /**
     * 通过一个字符串创建出一个 DateTime 对象
     * 字符串的规则 2014-04-09 11:10:38 或者 2014-04-09 1:0:38
     *
     * @param second 传入的秒数
     * @return 时间对象
     */
    public static DateTime createDateBySecond( int second ){
        return new DateTime( second * 1000L );
    }

    public static DateTime createDateByStr( String str ){
        return DateTime.parse( str, DATA_PATTERN );
    }

    /**
     * 把一个用秒数保存的时间值转换为易读的字符串
     *
     * @param seconds 秒数
     * @return 易读的字符串
     */
    public static String secondsToDateStr( int seconds ){
        DateTime dateTime = new DateTime( seconds * 1000l );
        return dateTime.toString( DATA_FORMAT_STR );
    }

    /**
     * 返回当前时间-输入时间的秒数，如果为负数则返回0
     *
     * @param dt 要比较的时间
     * @return 剩余的时间——秒数，小于0则返回0
     */
    public static int getRemainSecond( DateTime dt ){
        int ret = (int) (dt.getMillis() / 1000 - SystemTimer.currentTimeSecond());
        return Math.max( 0, ret );
    }

    /**
     * 返回当前时间-输入时间的分钟数，如果为负数则返回0
     * 简单起见，是向下取整，也就是说119秒，返回1分钟
     *
     * @param dt 要比较的时间
     * @return 剩余的时间——分钟数数，小于0则返回0
     */
    public static int getRemainMin( DateTime dt ){
        int ret = (int) (dt.getMillis() / 1000 - SystemTimer.currentTimeSecond());
        ret /= 60;
        return Math.max( 0, ret );
    }
}
