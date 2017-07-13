package com.qunar.proxy;

/**
 * Created by ershu.liang on 2017/7/12.
 */
public class HelloImpl implements Hello {

    private String str = "Hello";

    public HelloImpl(String str) {
        this.str = str;
    }

    public HelloImpl() {
    }

    @Tran
    @Override
    public String sayHello() {
       return str;
    }
}
