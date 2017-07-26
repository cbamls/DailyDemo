package com.qunar.algorithm;

/**
 * Created by ershu.liang on 2017/7/21.
 */

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class TestThread {

    private static AtomicInteger a = new AtomicInteger(1);

    public static void main(final String[] arguments) throws InterruptedException {
        ExecutorService executor = Executors.newCachedThreadPool();

        // Cast the object to its class type
        ThreadPoolExecutor pool = (ThreadPoolExecutor) executor;
        executor.submit(new TimeOutTask());
        for(int i = 0; i < 100; i++) {
            executor.submit(new Task());
        }
        executor.shutdown();
    }

    static class Task implements Runnable {

        public void run() {
            System.out.println("Running Task! Thread Name: " + (a.incrementAndGet()));
        }
    }
    static class TimeOutTask implements Runnable {

        public void run() {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Running Task! Thread Name: " + (a.incrementAndGet()));
        }
    }
}
