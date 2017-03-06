package com.offer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

class Element {

    @Override
    public int hashCode() {
     return 1;
    }

    @Override
    public boolean equals(Object obj) {
        //return super.equals(obj);
        System.out.println("equals");
        return true;
    }
}
public class TestSet {

    public static void main(String[] args) {
        Element element = new Element();
        Set set = new HashSet();
        set.add(new Element());
        set.add(new Element());
        System.out.println(set.size());
    }
}
