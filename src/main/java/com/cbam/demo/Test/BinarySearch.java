package com.cbam.demo.Test;

/**
 * CopyRright (c)2014-2016 Haerbin Hearglobal Co.,Ltd
 * Project: demo
 * Comments:
 * Author:cbam
 * Create Date:2017/3/13
 * Modified By:
 * Modified Date:
 * Modified Reason:
 */
public class BinarySearch {

    public static int binarySearch(int[] arr, int target) {
        if(arr ==  null || arr.length == 0) {
            return -1;
        }
        int low = 0;
        int high = arr.length - 1;
        while(low < high) {
            int mid = (low + high) >> 1;
            if(arr[mid] > target) {
                high = mid - 1;
            } else if(arr[mid] < target) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static int[] bubbleSort(int[] arr) {
        for(int i = 0; i < arr.length - 1; i++) {
            for(int j = i + 1; j < arr.length; j++) {
                if(arr[i] > arr[j]) {
                    int tmp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = tmp;
                }
            }
        }
        return arr;
    }
}
