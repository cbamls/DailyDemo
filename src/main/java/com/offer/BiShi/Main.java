package com.offer.BiShi;

import java.util.Scanner;

/**
 * CopyRright (c)2014-2016 Haerbin Hearglobal Co.,Ltd
 * Project: demo
 * Comments:
 * Author:cbam
 * Create Date:2017/3/26
 * Modified By:
 * Modified Date:
 * Modified Reason:
 */
public class Main {
    private static Integer i = 1;
    {
        System.out.println("cbam");
    }
    static {
        System.out.println("static");
    }
    public static void main(String[] args) {

        System.out.println(Main.i);
        new Main();
        new Main();
//        Scanner in = new Scanner(System.in);
//        while(in.hasNext()) {
//           String str = in.next();
//            System.out.println(str);
//        }
    }
}
