package com.offer;

/**
 * CopyRright (c)2014-2016 Haerbin Hearglobal Co.,Ltd
 * Project: demo
 * Comments:
 * Author:cbam
 * Create Date:2017/3/5
 * Modified By:
 * Modified Date:
 * Modified Reason:
 */
public class CutArray {
    private Integer[] arr;

    public Integer[] getArr() {
        return arr;
    }

    public void setArr(Integer[] arr) {
        this.arr = arr;
    }

    public CutArray(Integer[] arr) {
        this.arr = arr;
    }

    public Integer getMid(Integer[] arr, Integer sum) {
        int total = 0;
        for(int i = 0; i < arr.length; i++) {
            total += arr[i];
            if(total > sum) {
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        Integer[] arr = new Integer[]{2,2,2,3,2,2,2};
        CutArray cutArray = new CutArray(arr);
        int sum = 0;
        for(int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        Integer index = cutArray.getMid(arr, sum/2);
        System.out.println(index);
    }
}
