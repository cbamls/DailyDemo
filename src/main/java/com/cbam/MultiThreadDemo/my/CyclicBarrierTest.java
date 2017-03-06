package com.cbam.MultiThreadDemo.my;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

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
public class CyclicBarrierTest {

     static CyclicBarrier c = new CyclicBarrier(2);

    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
        new Thread(() -> {
            try {
                c.await();
                System.out.println(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }).start();
        c.await();
        System.out.println(2);
    }
}
