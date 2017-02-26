package com.cbam.demo.Test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * CopyRright (c)2014-2016 Haerbin Hearglobal Co.,Ltd
 * Project: demo
 * Comments:
 * Author:cbam
 * Create Date:2017/2/20
 * Modified By:
 * Modified Date:
 * Modified Reason:
 */
public class Child {
    private String str2;
    private static Logger LOGGER = LoggerFactory.getLogger(Child.class);

    public static void main(String[] args) {
        Child child = new Child();
       LOGGER.info("child data:{}", child);

    }

    public String getStr2() {
        return str2;
    }

    public void setStr2(String str2) {
        this.str2 = str2;
    }
}
