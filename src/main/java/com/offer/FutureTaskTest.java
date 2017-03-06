package com.offer;

import java.util.concurrent.*;

/**
 * CopyRright (c)2014-2016 Haerbin Hearglobal Co.,Ltd
 * Project: demo
 * Comments:
 * Author:cbam
 * Create Date:2017/3/4
 * Modified By:
 * Modified Date:
 * Modified Reason:
 */
public class FutureTaskTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        Future future = executorService.submit(() -> {
            System.out.println("hello");
        }, "test");
        Future future1 = executorService.submit(() -> {
            Thread.sleep(5000);
            return " hello java ";
        });
        Object object = future.get();
        System.out.println(object);
        System.out.println(future1.get());
    }
}
