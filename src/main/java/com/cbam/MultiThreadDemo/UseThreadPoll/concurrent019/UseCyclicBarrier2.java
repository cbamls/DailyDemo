package com.cbam.MultiThreadDemo.UseThreadPoll.concurrent019;

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

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.*;


public class UseCyclicBarrier2 {

    static class Runner implements Runnable {
        private String name;

        private static CyclicBarrier barrier = new CyclicBarrier(3);  // 3

        public Runner(String name) {

            this.name = name;
        }
        @Override
        public void run() {
            try {
                Thread.sleep(1000 * (new Random()).nextInt(5));
                System.out.println(name + " 准备OK.");
                barrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println(name + " Go!!");
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {

        ExecutorService executor = Executors.newFixedThreadPool(3);

        executor.submit(new Thread(new Runner("zhangsan")));
        executor.submit(new Thread(new Runner("lisi")));
        executor.submit(new Thread(new Runner("wangwu")));
        ThreadPoolExecutor
        executor.shutdown();
    }

}