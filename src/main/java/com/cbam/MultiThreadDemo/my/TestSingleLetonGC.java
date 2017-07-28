package com.cbam.MultiThreadDemo.my;

import java.util.concurrent.TimeUnit;

/**
 * Created by ershu.liang on 2017/7/28.
 */

class SingleLeton {
    private SingleLeton(){}
    private static Instance instance = new Instance();
    public static Instance getInstance()  {
        return instance;
    }
}
class Instance {

}
public class TestSingleLetonGC {
    private byte[] a = new byte[6*1024*1024];
//    private static TestSingleLetonGC singleLetonGC = new TestSingleLetonGC();
//    private TestSingleLetonGC() {}
//    public static TestSingleLetonGC getInstance() {
//        return singleLetonGC;
//    }

    public static void main(String[] args) throws InterruptedException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        System.out.println(SingleLeton.getInstance().hashCode());
        System.out.println(SingleLeton.getInstance().hashCode());
//        MyClassLoader cl = new MyClassLoader("myClassLoader");
//        MyClassLoaderTwo c2 = new MyClassLoaderTwo("MyClassLoaderTwo");
//        Class<?> clazz = cl.loadClass("com.cbam.MultiThreadDemo.my.SingleLeton");
//        Class<?> clazz2 = c2.loadClass("com.cbam.MultiThreadDemo.my.SingleLeton");
//        SingleLeton singleLeton = (SingleLeton) clazz.newInstance();
//        SingleLeton singleLeton2 = (SingleLeton) clazz2.newInstance();
//        singleLeton.getInstance();
//        singleLeton2.getInstance();
//        singleLeton = singleLeton2;
//        SingleLeton single = new SingleLeton();
//        singleLeton = single;
//        System.out.println(singleLeton.equals(singleLeton2));
//        System.out.println(singleLeton.getClass().getClassLoader().getClass().getName() + " " + singleLeton2.getClass().getClassLoader().getClass().getName());
//        while(true) {
//            TimeUnit.SECONDS.sleep(2);
//            System.gc();
//        }
    }
}
