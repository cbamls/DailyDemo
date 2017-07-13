package com.qunar.proxy;

import javax.transaction.TransactionManager;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by ershu.liang on 2017/7/12.
 */
public class TestProxy {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        String name = Hello.class.getSimpleName();
        System.out.println(Hello.class.isAnnotationPresent(TestAnno.class));
        //final Hello service = (Hello) Class.forName("com.qunar.proxy.HelloImpl").newInstance();
        Hello service = new HelloImpl();
        Hello proxyService = (Hello) Proxy.newProxyInstance(
                service.getClass()
                        .getClassLoader(), service.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        if (method.isAnnotationPresent(Tran.class)) {
                            Object obj = method.invoke(service, args);
                            return obj;
                        }
                        if(HelloImpl.class.isAnnotationPresent(TestAnno.class)) {
                            System.out.println("cunzai ");
                        }
                        return null;
                    }
                }
        );
        System.out.println(proxyService.sayHello());
    }
}
