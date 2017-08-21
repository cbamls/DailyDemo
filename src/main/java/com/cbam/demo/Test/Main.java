package com.cbam.demo.Test;
//
//import java.io.File;
//import java.io.IOException;
//import java.nio.file.Files;
//import java.util.HashMap;
//import java.util.LinkedList;
//import java.util.List;
//import java.util.Scanner;
//import java.util.concurrent.*;
//import java.util.concurrent.atomic.LongAdder;
//
///**
// * CopyRright (c)2014-2016 Haerbin Hearglobal Co.,Ltd
// * Project: demo
// * Comments:
// * Author:cbam
// * Create Date:2017/3/19
// * Modified By:
// * Modified Date:
// * Modified Reason:
// */
//
//public class Main2 {
////    public int[] sort(int [] arr) {
////        for(int i = 0; i < arr.length - 1; i++) {
////            for(int j = 0; j < arr.length - i - 1; j++) {
////                if(arr[j] > arr[j + 1]) {
////                    int tmp = arr[j];
////                    arr[j] = arr[j + 1];
////                    arr[j + 1] = tmp;
////                }
////            }
////        }
////        return arr;
////    }
//
//    public Character get(String arr) {
//        HashMap<Character, Integer> mp = new HashMap<>();
//        HashMap<Character, Integer> flag = new HashMap<>();
//        List<Character> list = new LinkedList<Character>();
//        for(int i = 0; i < arr.length(); i++) {
//            if(!mp.containsKey(arr.charAt(i))) {
//                mp.put(arr.charAt(i), 1);
//            } else {
//                mp.put(arr.charAt(i), mp.get(arr.charAt(i)) + 1);
//            }
//            if(mp.get(arr.charAt(i)) == 3) {
//                list.add(arr.charAt(i));
//                flag.put(arr.charAt(i), 1);
//            }
//            if(mp.get(arr.charAt(i)) > 3) {
//                flag.put(arr.charAt(i), 0);
//            }
//        }
//        for(int i = 0; i < list.size(); i++) {
//            Character ch = list.get(i);
//            if(flag.get(ch) == 1) {
//                return ch;
//            }
//        }
//        return  '8';
//    }
//    public static void main(String[] args) {
//        String str = "aacabbbaaa";
//
//        Character ch = new Main2().get(str);
//        System.out.println(ch);
////        ExecutorService cachePool = Executors.newCachedThreadPool();
////        cachePool.execute(() -> {
////         while(true){
////             System.out.println("cbam");
////             try {
////                 Thread.sleep(1000);
////             } catch (InterruptedException e) {
////                 e.printStackTrace();
////             }
////         }
////        });
////        cachePool.shutdown();
////        System.out.println(cachePool.isTerminated());
////          while(!cachePool.isTerminated()) {
////              System.out.println("weiwiweiwei");
////              Thread.sleep(500);
////          }
////        Thread p = new MyThread();
////        p.start();
////        Thread.sleep(1000);
////        p.interrupt();
////        File file = new File("E:\\x\\picture\\户口页2.jpg");
////        System.out.println(file.getParentFile().exists());
////        while(!file.getParentFile().exists()) {
////            System.out.println("cbam");
////        }
////        try {
////            Files.copy(file.toPath(), new File("E:\\x\\户口页2.jpg").toPath());
////        } catch (IOException e) {
////            e.printStackTrace();
////        }
////        Integer a = new Integer(3);
////        Integer b = new Integer(3); // 将3自动装箱成Integer类型
////        int c = 3;
////        System.out.println(a == b); // false 两个引用没有引用同一对象
////        System.out.println(a == c); // true a自动拆箱成int类型再和c比较
//
//    }
//}
//
//class MyThread extends Thread {
//
//    BlockingQueue<String> blockingQueue = new LinkedBlockingQueue<>();
//    public void run() {
//        for(int i = 0; i < 10000; i++) {
//            blockingQueue.offer("i = " + i);
//        }
//        System.out.println(blockingQueue.size());
//        while(!this.isInterrupted()) {
//            try {
//                String message = blockingQueue.poll(2, TimeUnit.SECONDS);
//                System.out.println(message);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//                System.out.println("异常");
//            }
//        }
//        System.out.println("stop");
//    }
//}

import org.springframework.web.servlet.DispatcherServlet;

import java.awt.*;

public class Main{
    public static void main(String[] args) {
        try {
            System.out.println(3 / 0);
        } catch (Exception e) {
            System.out.println("bam");
            e.printStackTrace();
        }
    }
}

/*
1 2 3
4 5 6
7 0 8
 */