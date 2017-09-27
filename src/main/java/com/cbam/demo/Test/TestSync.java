package com.cbam.demo.Test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by ershu.liang on 2017/8/29.
 */
public class TestSync {

    private ReentrantLock lock = new ReentrantLock();

    private void test(int i) throws InterruptedException {
        try {
            lock.lock();
            throw new Exception("cbam => " + i);
        } catch (Exception e) {
            e.printStackTrace();
            TimeUnit.SECONDS.sleep(3);
        }
    }

    public static void main(String[] args) {
        TestSync testSync = new TestSync();
        Thread thread = new Thread() {

            @Override
            public void run() {
                try {
                    testSync.test(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        thread.run();
        new Runnable() {

            @Override
            public void run() {
                try {
                    testSync.test(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.run();
    }
}
