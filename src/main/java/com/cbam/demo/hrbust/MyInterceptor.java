package com.cbam.demo.hrbust;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * Created by Chris on 2017/3/29.
 */
public class MyInterceptor implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        // 获取目标方法参数
        Object[] args = methodInvocation.getArguments();
        // 环绕增强的前半部分
        System.out.println("do something before in around advice");

        // 调用目标方法
        Object o = methodInvocation.proceed();

        // 环绕增强的后半部分
        System.out.println("do something after in around advice");

        return o;
    }
}
