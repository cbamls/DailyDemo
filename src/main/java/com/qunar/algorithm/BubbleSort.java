package com.qunar.algorithm;

/**
 * CopyRright (c)2014-2016 Haerbin Hearglobal Co.,Ltd
 * Project: DailyDemo
 * Comments:
 * Author:cbam
 * Create Date:2017/9/3
 * Modified By:
 * Modified Date:
 * Modified Reason:
 */
public class BubbleSort {
    public static void sort(int[] a) {
        for(int i = 0; i < a.length - 1; i++) {
            for(int j = 0; j < a.length - i - 1; j++) {
                if(a[j] > a[j + 1]) {
                    a[j] = a[j] ^ a[j + 1];
                    a[j + 1] = a[j] ^ a[j + 1];
                    a[j] = a[j] ^ a[j + 1];
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{10, 8, 102, 234, 22, 1};
        sort(arr);
        for(int a: arr) {
            System.out.println(a);
        }
    }
}
