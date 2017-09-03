package com.qunar.algorithm;

import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

/**
 * CopyRright (c)2014-2016 Haerbin Hearglobal Co.,Ltd
 * Project: DailyDemo
 * Comments:
 * Author:cbam
 * Create Date:2017/7/30
 * Modified By:
 * Modified Date:
 * Modified Reason:
 */
public class HeapSort {

    public static void sort(int[] a) {
        for (int i = a.length / 2; i > 0; i--) {
            heapJust(a, i, a.length);
        }
        for(int i = a.length - 1; i >= 0; i--) {
            int tmp = a[i];
            a[i] = a[0];
            a[0] = tmp;
            heapJust(a, 0, i);
        }
    }

    private static void heapJust(int arr[], int top, int len) {
        int tmp = arr[top];
        int child = 2 * top;
        while (child <= len) {
            if (child + 1 < arr.length && arr[2 * child] < arr[2 * child + 1]) {
                top++;
            }
            if(top < tmp) {
                break;
            }
            arr[top] = arr[child];
            top = child;
            child = 2 * child;
        }
        arr[top] = tmp;
    }
}
