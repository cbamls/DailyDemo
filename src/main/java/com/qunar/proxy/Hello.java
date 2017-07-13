package com.qunar.proxy;

/**
 * Created by ershu.liang on 2017/7/12.
 */
@TestAnno
public interface Hello {
    @Tran
    String sayHello();
}
