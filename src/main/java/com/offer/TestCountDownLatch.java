package com.offer;

import com.cbam.demo.OptionalDemo.Test;

import java.util.concurrent.CountDownLatch;

/**
 * CopyRright (c)2014-2016 Haerbin Hearglobal Co.,Ltd
 * Project: demo
 * Comments:
 * Author:cbam
 * Create Date:2017/3/7
 * Modified By:
 * Modified Date:
 * Modified Reason:
 */
public class TestCountDownLatch {
    private static CountDownLatch cdl = new CountDownLatch(3);

    public void execute() {
        new Thread(() -> {
            try {
                cdl.await();
                System.out.println("执行");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

    public static void main(String[] args) {
        TestCountDownLatch tcd = new TestCountDownLatch();
        tcd.execute();
        tcd.execute();
        cdl.countDown();
        cdl.countDown();
    }
}
