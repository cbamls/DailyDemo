package com.cbam.demo.pattern;

import java.util.AbstractQueue;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.ReentrantLock;

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
public class MainTest {
    public static void main(String[] args) {
        //我先定一杯饮料
        Beverage espresso = new Espresso();

        //我要加一些调料  用mocha调料去装饰espresso饮料
        Mocha mocha = new Mocha(espresso);

        //计算总价钱
        System.out.println(mocha.getDescription());
        System.out.println(mocha.cost());

        StringBuilder builder = new StringBuilder();
        builder.append("s");
        System.out.println(builder.hashCode());
        builder.append("y");
        System.out.println(builder.hashCode());
    }
}
