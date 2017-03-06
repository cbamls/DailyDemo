package com.cbam.demo.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

/**
 * CopyRright (c)2014-2016 Haerbin Hearglobal Co.,Ltd
 * Project: demo
 * Comments:
 * Author:cbam
 * Create Date:2017/2/21
 * Modified By:
 * Modified Date:
 * Modified Reason:
 */
public class DoubleCheck {
    private volatile static DoubleCheck doubleCheck;
    private static CyclicBarrier cyclicBarrier = new CyclicBarrier(10);
    private static CountDownLatch countDownLatch = new CountDownLatch(1);
    private DoubleCheck() {

    }

    public static DoubleCheck getInstance() throws InterruptedException {

        if(doubleCheck == null) {
            try {
                System.out.println("++++");
                //cyclicBarrier.await();
                countDownLatch.await();
            } catch (Exception e) {
                e.printStackTrace();
            }
            synchronized (DoubleCheck.class) {
                if(doubleCheck == null) {
                    doubleCheck = new DoubleCheck();
                }
            }
        }
        return doubleCheck;
    }

    public static void main(String[] args) throws InterruptedException {
        //System.out.println(DoubleCheck.getInstance().hashCode() + " 1");
        for(int i = 0; i < 10; i++) {

            new Thread(() -> {
                try {
                    System.out.println(DoubleCheck.getInstance().hashCode());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
        countDownLatch.countDown();
    }
}
