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
public class DeepthFirstSearch {

    private static Integer[] boxs = new Integer[10];

    private static int[] books = new int[10];

    private static int total = 0;

    private static void dfs(int step) {
        if(step == 9) {
            for(int j = 1; j < 9; j++) {
                System.out.print(boxs[j]);
            }
            System.out.println();
            total++;
            return ;
        }

        for(int i = 1; i < 9; i++) {
            if(books[i] == 0) {
                books[i] = 1;
                boxs[step] = i;
                dfs(step + 1);
                books[i] = 0;
            }
        }
        return ;
    }

    public static void main(String[] args) {
        dfs(1);
        Thread thread = new Thread(() -> {
            System.out.println("cbam");
        });
        System.out.println(total);
    }

}
