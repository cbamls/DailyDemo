package com.offer;

/**
 * CopyRright (c)2014-2016 Haerbin Hearglobal Co.,Ltd
 * Project: demo
 * Comments:
 * Author:cbam
 * Create Date:2017/3/6
 * Modified By:
 * Modified Date:
 * Modified Reason:
 */
public class BiShi2 {

    /**
     * Resolve boolean.
     * 思路是先划分两边， 再判断中间结点
     * @param A the a
     * @return the boolean
     */
    public static boolean resolve(int [] A) {
        int begin = 0;
        int end = A.length - 1;
        int beginSum = A[begin]; //
        int endSum = A[end];

        while(beginSum != endSum) {
            if(beginSum < endSum) {
                begin++;
                beginSum += A[begin];
            } else {
                end--;
                endSum += A[end];
            }
        }
        // now beginSum == endSum
        if(end - begin < 3) {
            return false;
        }
        //init beginSum = 0  find the middle index
        beginSum = 0;
        boolean flag = false;
        int index = begin + 1;
        for(int i = begin + 2; i < end - 1; i++) {
            beginSum += A[i];
            if(beginSum == endSum) {
                index = i;
                flag = true;
            }
        }
        // if possible  we should judge the third partition
        beginSum = 0;
        if(flag) {
            for(int j = index + 2 ; j < end - 1; j++) {
                beginSum += A[j];
            }
            if(beginSum == endSum) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] A = new int[]{2, 5, 1, 1, 1, 1, 4, 1, 7, 3, 7};
        System.out.println(resolve(A));;
    }
}
