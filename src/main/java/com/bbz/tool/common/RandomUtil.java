package com.bbz.tool.common;

import java.util.Random;

/**
 * user         LIUKUN
 * com.bbz.com.bbz.tool.com.bbz.com.bbz.tool.time         2014-4-9 11:04
 */
public class RandomUtil{

    private static Random r = new Random();

    private RandomUtil(){
    }

    /**
     * 随机获取一个[0,max)范围的整型数字
     *
     * @param max 随机值上限
     * @return 随机返回的整型数字
     */
    public static int getInt( int max ){
        return r.nextInt( max );
    }

    /**
     * 返回[min,max)之间的整数
     *
     * @param min 下限（包括）
     * @param max 上限（不包括）
     * @return 随机返回的数字
     */
    public static int getInt( int min, int max ){
        if( max <= min ) {
            throw new IllegalArgumentException( "max < min" );
        }
        int temp = max - min;
        temp = r.nextInt( temp );
        return temp + min;

    }

    /**
     * 以一定几率发生某件事发生
     *
     * @param percent 发生的几率 如果大于等于1就一定发生，小于0肯定不发生
     * @return true: 发生, false: 未发生
     */
    public static boolean isHappen( float percent ){
        return percent >= 1 || percent >= 0 && percent > r.nextFloat();
    }

    public static void main( String[] args ){
        RandomUtil.isHappen( 0.2f );
    }
}
