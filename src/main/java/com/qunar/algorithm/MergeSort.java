package com.qunar.algorithm;

/**
 * Created by ershu.liang on 2017/7/31.
 */
public class MergeSort {
    public static int[] sort(int[] nums, int low, int high) {
        int mid = (low + high) >> 1;
        if (low < high) {
            sort(nums, low, mid);
            sort(nums, mid + 1, high);
            merge(nums, low, mid, high);
        }
        return nums;
    }

    public static void merge(int[] nums, int low, int mid, int high) {
        int[] tmp = new int[high - low + 1];
        int i = low;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= high) {
            if (nums[i] < nums[j]) {
                tmp[k++] = nums[i];
            } else {
                tmp[k++] = nums[j];
            }
        }
        while (i <= mid) {
            tmp[k++] = nums[i];

        }
        while (j <= high) {
            tmp[k++] = nums[j];
        }
        for (int m = 0; m < nums.length; m++) {
            nums[m + low] = tmp[m];
        }
    }
}
