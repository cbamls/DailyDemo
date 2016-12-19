package com.cbam.demo.aop;

import org.aspectj.lang.annotation.Around;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * CopyRright (c)2014-2016 Haerbin Hearglobal Co.,Ltd
 * Project: demo
 * Comments:
 * Author:cbam
 * Create Date:2016/10/23
 * Modified By:
 * Modified Date:
 * Modified Reason:
 */
public class Log implements MethodBeforeAdvice {
    /**
     * @param method 被调用的方法对象
     * @param objects 被调用的方法的参数
     * @param o 被调用的方法的目标对象 即被代理的对象
     * @throws Throwable
     */
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println(o.getClass().getName() + " " + method.getName());
        for(Object object : objects) {
            System.out.println(object);
        }
    }


}
