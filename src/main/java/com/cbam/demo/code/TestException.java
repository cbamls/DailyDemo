package com.cbam.demo.code;

import com.google.common.base.Preconditions;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by ershu.liang on 2017/7/24.
 */
public class TestException {
    public static void main(String[] args) {
        try {

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("e.getCause()    " + e.getCause());
            System.out.println("e.getMessage()  " + e.getMessage());
            System.out.println("e.getStackTrace() " + e.getStackTrace().toString());
            System.out.println("e.toString() " + e.toString());
        }
    }
}
