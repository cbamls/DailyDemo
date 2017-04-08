package com.cbam.demo.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

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
public class ProxyInovationHandler implements InvocationHandler {
  //要代理的类
   private Object object;

    /**
     * 生成代理类
     */
    public Object getProxy() {
        return Proxy.newProxyInstance(this.getClass().getClassLoader(),
                object.getClass().getInterfaces(), this);
    }
    /**
     * @param proxy 是代理类
     * @param method 代理类的调用处理程序 的方法的对象 可以通过method.getName()获取该方法的该方法名
     * @param args
     * @return
     * @throws Throwable
     */

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        common1();
        Object result = method.invoke(object, args);
        common2();
        return result;
    }

    public Object getRent() {
        return object;
    }

    public void setRent(Rent rent) {
        this.object = rent;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
    public void common1() {
        System.out.println("公共方法1");
    }
    public void common2() {
        System.out.println("公共方法2");
    }
}
