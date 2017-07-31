package com.qunar.algorithm;

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
}
