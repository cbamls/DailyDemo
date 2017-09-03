package com.cbam.demo.Test;

/**
 * CopyRright (c)2014-2016 Haerbin Hearglobal Co.,Ltd
 * Project: DailyDemo
 * Comments:
 * Author:cbam
 * Create Date:2017/8/31
 * Modified By:
 * Modified Date:
 * Modified Reason:
 */

public class SafeDoubleCheckedLocking {
    private SafeDoubleCheckedLocking() {

    }
    private volatile static SafeDoubleCheckedLocking instance;
    public static SafeDoubleCheckedLocking getInstance() {
        if(instance == null) {
            synchronized (SafeDoubleCheckedLocking.class) {
                if(instance == null) {
                    instance = new SafeDoubleCheckedLocking();
                }
            }
        }
        return instance;
    }

    private static class InstanceHolder {
        public static SafeDoubleCheckedLocking instance = new SafeDoubleCheckedLocking();
    }

    public static SafeDoubleCheckedLocking getInstanceTwo() {
        return InstanceHolder.instance;
    }
}
