package com.cbam.demo.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Scanner;
import java.util.concurrent.*;
import java.util.concurrent.atomic.LongAdder;

/**
 * CopyRright (c)2014-2016 Haerbin Hearglobal Co.,Ltd
 * Project: demo
 * Comments:
 * Author:cbam
 * Create Date:2017/3/19
 * Modified By:
 * Modified Date:
 * Modified Reason:
 */

public class Main {

    public static void main(String[] args) {
//        ExecutorService cachePool = Executors.newCachedThreadPool();
//        cachePool.execute(() -> {
//         while(true){
//             System.out.println("cbam");
//             try {
//                 Thread.sleep(1000);
//             } catch (InterruptedException e) {
//                 e.printStackTrace();
//             }
//         }
//        });
//        cachePool.shutdown();
//        System.out.println(cachePool.isTerminated());
//          while(!cachePool.isTerminated()) {
//              System.out.println("weiwiweiwei");
//              Thread.sleep(500);
//          }
//        Thread p = new MyThread();
//        p.start();
//        Thread.sleep(1000);
//        p.interrupt();
//        File file = new File("E:\\x\\picture\\户口页2.jpg");
//        System.out.println(file.getParentFile().exists());
//        while(!file.getParentFile().exists()) {
//            System.out.println("cbam");
//        }
//        try {
//            Files.copy(file.toPath(), new File("E:\\x\\户口页2.jpg").toPath());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        Integer a = new Integer(3);
//        Integer b = new Integer(3); // 将3自动装箱成Integer类型
//        int c = 3;
//        System.out.println(a == b); // false 两个引用没有引用同一对象
//        System.out.println(a == c); // true a自动拆箱成int类型再和c比较

    }
}

class MyThread extends Thread {

    BlockingQueue<String> blockingQueue = new LinkedBlockingQueue<>();
    public void run() {
        for(int i = 0; i < 10000; i++) {
            blockingQueue.offer("i = " + i);
        }
        System.out.println(blockingQueue.size());
        while(!this.isInterrupted()) {
            try {
                String message = blockingQueue.poll(2, TimeUnit.SECONDS);
                System.out.println(message);
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println("异常");
            }
        }
        System.out.println("stop");
    }
}