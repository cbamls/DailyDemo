package com.cbam.demo.pattern;

/**
 * CopyRright (c)2014-2016 Haerbin Hearglobal Co.,Ltd
 * Project: demo
 * Comments:
 * Author:cbam
 * Create Date:2017/3/18
 * Modified By:
 * Modified Date:
 * Modified Reason:
 */
public abstract class Beverage {
    String description = "Unkown Beverage";

    public String getDescription() {
        return description;
    }

    public abstract double cost();
}
