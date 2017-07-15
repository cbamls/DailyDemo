package com.qunar.algorithm;

/**
 * Created by ershu.liang on 2017/7/13.
 */
public class QuickSort {
//    public void quickSort(Integer[] arr, int low, int high) {
//        if(low < high) {
//            int mid = getMid(arr, low, high);
//            quickSort(arr, 0, mid);
//            quickSort(arr, mid + 1, high);
//        }
//    }

    public void quickSort(Integer[] arr, int low, int high) {
        if (low < high) {
            int mid = getMid(arr, low, high);
            quickSort(arr, 0, mid);
            quickSort(arr, mid + 1, high);
        }
    }

    public int getMid(Integer arr[], int low, int high) {
        int key = arr[low];
        while (low < high) {
            while (arr[high] >= key && low < high) {
                high--;
            }
            arr[low] = arr[high];
            while (arr[low] <= key && low < high) {
                low++;
            }
            arr[high] = arr[low];
        }
        arr[low] = key;
        return low;
    }
//    public int getMid(Integer[] arr, int low, int high) {
//        int key = arr[low];
//        while(low < high) {
//            while(arr[high] >= key && low < high) {
//                high--;
//            }
//            arr[low] = arr[high];
//            while(arr[low] <= key && low < high) {
//                low ++;
//            }
//            arr[high] = arr[low];
//        }
//
//        arr[low] = key;
//        return low;
//    }
}
