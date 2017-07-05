package com.qunar.algorithm;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by ershu.liang on 2017/7/4.
 */
public class Singleton {

    public static class Instance {

    }
    public static class DoubleCheck {
        private DoubleCheck() {
        }

        public volatile static Instance instance;

        public static Instance getInstance() {
            if(instance == null) {
                synchronized (DoubleCheck.class) {
                    if(instance == null) {
                        instance = new Instance();
                    }
                }
            }
            return instance;
        }

    }

    public static class InitClass {
        private static class InstanceHolder {
            public static Instance instance = new Instance();
        }

        public static Instance getInstance() {
            return InstanceHolder.instance;
        }
    }

    public static void main(String[] args) {

    }
}
