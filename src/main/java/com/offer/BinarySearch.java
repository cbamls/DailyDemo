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
public class BinarySearch {


    private static int binarySearch(int[] arr, int target) {
        if(arr == null || arr.length == 0) {
            return -1;
        }
        int low = 0;
        int high = arr.length - 1;
        while(low < high) {
            int mid = (low + high) >> 2;
            if(arr[mid] > target) {
                high = mid - 1;
            } else if( arr[mid] < target ) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return  -1;
    }
}
