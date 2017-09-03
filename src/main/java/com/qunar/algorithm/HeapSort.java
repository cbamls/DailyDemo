package com.qunar.algorithm;

<<<<<<< HEAD
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
=======
/**
 * Created by ershu.liang on 2017/7/31.
 */
public class HeapSort {

    public static void adjustHeap(int[] arr, int top, int len) {
        int tmp, j;
        tmp = arr[top];
        for(j = 2 * top; j < len; j *= 2) {
            if(arr[j] < arr[j + 1]) {
                j++;
            }
            if(tmp >= arr[j]) {
                break;
            }
            arr[top] = arr[j];
            top = j;
        }
        arr[top] = tmp;
    }

    public static void heapSort(int[] arr) {
        for(int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, arr.length - 1);
        }
        for(int i = arr.length - 1; i >= 0; i--) {
            arr[0] = arr[0] ^ arr[i];
            arr[i] = arr[0] ^ arr[i];
            arr[0] = arr[0] ^ arr[i];
            adjustHeap(arr, 0, i - 1);
        }
    }
>>>>>>> 14ad934b263572ccdaa71372fd5856d0c7826f26
}
