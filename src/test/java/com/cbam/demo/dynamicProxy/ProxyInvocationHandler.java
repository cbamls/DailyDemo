package com.cbam.demo.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * CopyRright (c)2014-2016 Haerbin Hearglobal Co.,Ltd
 * Project: demo
 * Comments:
 * Author:cbam
 * Create Date:2017/3/29
 * Modified By:
 * Modified Date:
 * Modified Reason:
 */
public class ProxyInvocationHandler implements InvocationHandler {
   //要代理的对象
    private Object target;

    public ProxyInvocationHandler(Object target) {
        this.target = target;
    }

    public Object getProxy() {
        return Proxy.newProxyInstance(Thread.currentThread()
                .getContextClassLoader(), target.getClass().getInterfaces(),
                this);
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("----- before -----");
        Object rtn = method.invoke(target, args);
        System.out.println("----- after -----");
        return rtn;
    }
}
