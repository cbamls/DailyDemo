package com.cbam.demo.code;

import java.util.LinkedList;
import java.util.List;

/**
 * CopyRright (c)2014-2016 Haerbin Hearglobal Co.,Ltd
 * Project: demo
 * Comments:
 * Author:cbam
 * Create Date:2017/4/7
 * Modified By:
 * Modified Date:
 * Modified Reason:
 */
public class MyStack {
    private List<Integer> aList = new LinkedList<>();
    private List<Integer> bList = new LinkedList<>();

    public void push(int x) {
        if(!aList.isEmpty()) {
            aList.add(x);
        } else {
            bList.add(x);
        }
    }
}
