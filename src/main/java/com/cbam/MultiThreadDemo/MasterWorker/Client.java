package com.cbam.MultiThreadDemo.MasterWorker;

import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

/**
 * CopyRright (c)2014-2016 Haerbin Hearglobal Co.,Ltd
 * Project: demo
 * Comments:
 * Author:cbam
 * Create Date:2017/1/30
 * Modified By:
 * Modified Date:
 * Modified Reason:
 */
public class Client {
    public static void main(String[] args) {
        Master master = new Master(new Worker(), Runtime.getRuntime().availableProcessors());
        System.out.println("Runtime.getRuntime().availableProcessors() => " + Runtime.getRuntime().availableProcessors());
        for(int i = 0; i < 100; i++) {
            Task task = new Task();
            task.setId(i);
            task.setName("task => " + i);
            Random random = new Random();
            task.setPrice(random.nextInt(20));
            master.submit(task);
        }
        master.execute();
        ConcurrentHashMap concurrentHashMap = (ConcurrentHashMap) master.getResult();
        long start = System.currentTimeMillis();
        while (!master.isComplete()) {

        }
        long end = System.currentTimeMillis() - start;
        for(Object each : concurrentHashMap.entrySet()) {
            Map.Entry entry = (Map.Entry) each;
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        System.out.println("执行总耗时： => " + end);

    }
}
