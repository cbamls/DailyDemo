package com.cbam.demo.dynamicProxy;

import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;
import java.io.IOException;

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
public class HelloServiceImpl implements HelloService {
    @Override
    public void sayHello(String name) {
        System.out.println("Hello " + name);
    }

//    public static void main(String[] args) {
//        public static void main(String[] args) {
//            HelloService helloService = new HelloServiceImpl();
//            ProxyInvocationHandler proxyInovationHandler = new ProxyInvocationHandler(helloService);
//            HelloService proxy = (HelloService) proxyInovationHandler.getProxy();
//            proxy.sayHello("梁舒");
//
//            String path = "D:/$Proxy0.class";
//            byte[] classFile = ProxyGenerator.generateProxyClass("$Proxy0",
//                    HelloServiceImpl.class.getInterfaces());
//            FileOutputStream out = null;
//
//            try {
//                out = new FileOutputStream(path);
//                out.write(classFile);
//                out.flush();
//            } catch (Exception e) {
//                e.printStackTrace();
//            } finally {
//                try {
//                    out.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }
}
