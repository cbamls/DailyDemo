package com.cbam.demo.code;

import com.cbam.MultiThreadDemo.coll013.Task;

/**
 * Created by ershu.liang on 2017/7/26.
 */
public class TestThread {

    public static void test() {

    }
    static class Task1 implements Runnable {

        @Override
        public void run() {
           while (true) {
               System.out.println("testThreadName : -> " + Thread.currentThread().getName());
               test();
           }
        }
    }
    static class Task2 implements Runnable {

        @Override
        public void run() {
           while (true) {
               test();
           }
        }
    }

    public static void main(String[] args) {
        TestThread testThread = new TestThread();
        Task1 task1 = new Task1();
        Task2 task2 = new Task2();
        task1.run();
        task2.run();
    }
}
