package com.cbam.demo.Test;

/**
 * CopyRright (c)2014-2016 Haerbin Hearglobal Co.,Ltd
 * Project: demo
 * Comments:
 * Author:cbam
 * Create Date:2017/2/26
 * Modified By:
 * Modified Date:
 * Modified Reason:
 */
public class QuickSort {
    Integer [] array = {3, 2,1};

//    public static void main(String[] args) {
//        QuickSort quickSort = new QuickSort();
//        quickSort.quickSort(quickSort.array, 0, 2);
//        System.out.println(quickSort.array.hashCode());
//    }
//
//    public void quickSort(Integer [] arr, int low, int high) {
//        if(low < high) {
//            int mid = getMiddle(array, 0, 2);
//            quickSort(arr, 0, mid - 1);
//            quickSort(arr, mid + 1, high);
//        }
//    }
//
//    public int getMiddle(Integer [] arr, int low, int high) {
//        int key = arr[low];
//        while(low < high) {
//            while(low < high && arr[high] >= key) {
//                high--;
//            }
//            arr[low] = arr[high];
//            while(low < high && arr[low] <= key) {
//                low++;
//            }
//            arr[high] = arr[low];
//        }
//        arr[low] = key;
//        return low;
//    }

        public void quickSort(Integer[] arr, int low, int high) {
          if(low < high) {
              int mid = getMid(arr, low, high);
              quickSort(arr, 0, mid);
              quickSort(arr, mid + 1, high);
          }
        }

        public int getMid(Integer[] arr, int low, int high) {
            int key = arr[low];
            while(low < high) {
                while(arr[high] >= key && low < high) {
                    high--;
                }
                arr[low] = arr[high];
                while(arr[low] <= key && low < high) {
                    low ++;
                }
                arr[high] = arr[low];
            }
            arr[low] = key;
            return low;
        }
}
//    public void quickSort(Integer[] arr, int low, int high) {
//        if(low < high) {
//            int mid = getMiddle(arr, 0, arr.length - 1);
//            quickSort(arr, 0, mid);
//            quickSort(arr, mid + 1, high);
//        }
//    }
//
//    public int getMiddle(Integer [] arr, int low, int high) {
//        int key = arr[low];
//        while(low < high) {
//            while(arr[high] >= key && low < high) {
//                high--;
//            }
//            arr[low] = arr[high];
//            while(arr[low] <= key && low < high) {
//                low++;
//            }
//            arr[high] = arr[low];
//        }
//        arr[low] = key;
//        return low;
//    }
//}
