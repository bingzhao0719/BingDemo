package com.bing.demo.bingdemo.utils;

/**
 * Created by wubingzhao on 2017/12/28.
 */

public class StringUtils {


    private static final char[] HEX = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};


    public static String toHexString(byte[] b) {
        StringBuilder sb = new StringBuilder(b.length * 2);

        for(int i = 0; i < b.length; ++i) {
            sb.append(HEX[(b[i] & 240) >>> 4]);
            sb.append(HEX[b[i] & 15]);
        }

        return sb.toString();
    }
}
