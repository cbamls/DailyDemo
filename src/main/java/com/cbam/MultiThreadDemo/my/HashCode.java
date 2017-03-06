package com.cbam.MultiThreadDemo.my;

/**
 * CopyRright (c)2014-2016 Haerbin Hearglobal Co.,Ltd
 * Project: demo
 * Comments:
 * Author:cbam
 * Create Date:2017/3/2
 * Modified By:
 * Modified Date:
 * Modified Reason:
 */
public class HashCode {
    public static long calculateDEK(byte[] src, int srcPos, int length) {
        long tmp = src.length;
        System.out.println(src.length);
        for (int i = srcPos; i < length; i++) {
            tmp = ((tmp << 5) ^ (tmp >> 27)) ^ src[i];
            System.out.println();
        }
        return tmp;
    }
//3473 17
    public static void main(String[] args) {
        String s = "1234";
        long i = calculateDEK(s.getBytes(),0,s.getBytes().length);
        System.out.println(i);
        System.out.println((1 << 1) ^ (1 >> 1));
    }
}
