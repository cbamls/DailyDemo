package com.cbam.MultiThreadDemo.conn009;

import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * CopyRright (c)2014-2016 Haerbin Hearglobal Co.,Ltd
 * Project: demo
 * Comments:
 * Author:cbam
 * Create Date:2017/1/26
 * Modified By:
 * Modified Date:
 * Modified Reason:
 */
public class MyQueue2 {

    private final LinkedList<Object> list = new LinkedList<>();

    private AtomicInteger count = new AtomicInteger(0);

    private final int minSize = 0;

    private final int maxSize;

    public MyQueue2(int size) {
        this.maxSize = size;
    }

    private final Object lock = new Object();

    public void put(Object obj) {
        synchronized (lock) {
            while(count.get() == this.maxSize) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            list.add(obj);
            System.out.println("新加入元素 => " + obj);
            count.incrementAndGet();
        }
    }



}
