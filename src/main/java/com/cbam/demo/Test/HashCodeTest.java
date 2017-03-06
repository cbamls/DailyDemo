package com.cbam.demo.Test;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/**
 * CopyRright (c)2014-2016 Haerbin Hearglobal Co.,Ltd
 * Project: demo
 * Comments:
 * Author:cbam
 * Create Date:2017/3/1
 * Modified By:
 * Modified Date:
 * Modified Reason:
 */
public class HashCodeTest {

    private Integer b = 1;


    public Integer getB() {
        return b;
    }

    public void setB(Integer b) {
        this.b = b;
    }


    @Override
    public boolean equals(Object obj) {
        System.out.println("调用equals");
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        System.out.println("调用hashcaode");
        return 1;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public static void main(String[] args) {
        HashCodeTest hashCodeTest = new HashCodeTest();
        HashCodeTest hashCodeTest1 = new HashCodeTest();
        hashCodeTest.setB(1);
        hashCodeTest1.setB(1);
        if(hashCodeTest == hashCodeTest1) {
            System.out.println("相等");
        }
//        Set<HashCodeTest> set = new LinkedHashSet<>();
//        set.add(new HashCodeTest());
//        set.add(hashCodeTest);

        Set<Integer> set = new LinkedHashSet<>();
        Integer a1 = new Integer(100000);
        Integer b1 = new Integer(100000);
        if(a1.equals(b1)) {
            System.out.println("ccc");
        }
        set.add(new Integer(100000));
        set.add(new Integer(100000));
        System.out.println(set.size());
    }
}
