package com.cbam.demo.Test;

import java.util.concurrent.locks.LockSupport;

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
class A {
    int a ;
    public A(int a) {
        this.a = a;
    }

    void setA(int a ) {
        this.a = a;
    }

    public int getA(int a) {
        return a;
    }
}
public class TestStatic {


    public static void t2() throws Exception
    {
        Thread t = new Thread(new Runnable()
        {
            private int count = 0;

            @Override
            public void run()
            {
                long start = System.currentTimeMillis();
                long end = 0;

                while ((end - start) <= 5000)
                {
                    count++;
                    end = System.currentTimeMillis();
                }

                System.out.println("after 5 second.count=" + count);

                //等待或许许可
                LockSupport.park();
                System.out.println("thread over." + Thread.currentThread().isInterrupted());

            }
        });

        t.start();

        Thread.sleep(10000);

        // 中断线程
        LockSupport.unpark(t);
        t.interrupt();


        System.out.println("main over");
    }

    static A a = new A(1);

    public static void main(String[] args) throws Exception {
        t2();
//        final A a1 = new A(222221);
//        System.out.println(a1.hashCode());
//        a1.setA(222222222);
//        System.out.println(a1.hashCode());
//
//        TestStatic testStatic_1 = new TestStatic();
//        System.out.println(testStatic_1.a.hashCode());
//
//        TestStatic testStatic_2 = new TestStatic();
//        System.out.println(testStatic_2.a.hashCode());

    }
}
