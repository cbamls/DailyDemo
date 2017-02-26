package com.cbam.demo.Test;

import java.util.LinkedList;

/**
 * CopyRright (c)2014-2016 Haerbin Hearglobal Co.,Ltd
 * Project: hkarea
 * Comments:
 * Author:cbam
 * Create Date:2017/2/16
 * Modified By:
 * Modified Date:
 * Modified Reason:
 */
public class Tester {
    String name = "a";
    public String getName() {
        name += "b";
        return name;
    }

    public static void main(String[] args) {

        System.out.println(new Tester().getName());
        System.out.println(new Tester().name);

    }
}
