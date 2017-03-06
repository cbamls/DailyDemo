package com.offer;

/**
 * CopyRright (c)2014-2016 Haerbin Hearglobal Co.,Ltd
 * Project: demo
 * Comments:
 * Author:cbam
 * Create Date:2017/3/4
 * Modified By:
 * Modified Date:
 * Modified Reason:
 */
public class Prime {

    public static Integer[] getPrimes(int n) {
        Integer[] arr = new Integer[20];
        for(int i = 2; i < n; i++) {
            arr[i] = i;
        }

        for(int i = 2; i < n; i++) {
            if(arr[i] != 0) {
                for(int j = i * 2; j < n; j += i) {
                    arr[j] = 0;
                }
            }
        }
        return arr;
    }
}
