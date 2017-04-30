package com.cbam.demo.code;

import com.cbam.demo.Test.Parent;

/**
 * CopyRright (c)2014-2016 Haerbin Hearglobal Co.,Ltd
 * Project: demo
 * Comments:
 * Author:cbam
 * Create Date:2017/4/9
 * Modified By:
 * Modified Date:
 * Modified Reason:
 */
public class Child extends Parent {
    public static void main(String[] args) {
        String s1 = new StringBuilder("go")
                .append("od").toString();
        System.out.println(s1.intern() == s1);
        String s2 = new StringBuilder("ja")
                .append("va").toString();
        System.out.println(s2.intern() == s2);
    }
}
