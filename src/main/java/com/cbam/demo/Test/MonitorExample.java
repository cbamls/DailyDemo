package com.cbam.demo.Test;

import com.cbam.MultiThreadDemo.sync007.RunThread;

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
public class MonitorExample {
    volatile int a = 0;
    public  void writer() {
        a++;
    }

    public  void reader() {
        a--;
    }

    public static void main(String[] args) throws InterruptedException {
        MonitorExample monitorExample = new MonitorExample();
        Thread t1 = new Thread(() -> {
            for(int i = 0; i < 100; i++) {
                monitorExample.writer();
            }
        });

        Thread t2 = new Thread(() -> {
            for(int i = 0; i < 100; i++) {
                monitorExample.reader();
            }
        });

        t1.start();
        t2.start();
        Thread.sleep(5000);
        System.out.println(monitorExample.a);
    }
}
