package com.qunar.algorithm;

import org.springframework.beans.BeanUtils;

/**
 * Created by ershu.liang on 2017/7/13.
 */
public class BinarySearch {

    public static int binarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) >> 1;
            if (arr[mid] >= target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return high + 1;
    }
    // 查找第一个等于或者大于key的元素
    public static int findFirstEqualLarger(int[] array, int key) {
        int left = 0;
        int right = array.length - 1;
        // 这里必须是 <=
        while (left <= right) {
            int mid = (left + right) / 2;
            if (array[mid] >= key) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        return left;
    }
    public static void main(String[] args) {
        int[] ints = {2, 2, 2, 2};
        System.out.println(binarySearch(ints, 2));
        System.out.println(findFirstEqualLarger(ints, 2));;
    }
}
