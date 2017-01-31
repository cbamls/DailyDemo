package com.cbam.demo.Test;

/**
 * CopyRright (c)2014-2016 Haerbin Hearglobal Co.,Ltd
 * Project: demo
 * Comments:
 * Author:cbam
 * Create Date:2017/1/31
 * Modified By:
 * Modified Date:
 * Modified Reason:
 */
public class Example {
    String str = new String("good");
    char ch[] = {'a', 'b', 'c'};

    public void exchange(String str, char ch[]) {
        str = "test ok";
        ch[0] = 'g';
    }

    public static void main(String[] args) {

        Example example = new Example();
        example.exchange(example.str, example.ch);
        System.out.println(example.str + " and " + example.ch[0]);
    }
}
