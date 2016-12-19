package com.cbam.demo.aop;

import javafx.application.Application;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * CopyRright (c)2014-2016 Haerbin Hearglobal Co.,Ltd
 * Project: demo
 * Comments: 利用SpringAPI来实现aop 和 自定义aop 和 注解aop
 * Srping aop 就是将公共的业务（如日志， 安全等）和领域业务结合。当执行领域业务时将会
 * 把公共业务加进来，那么程序员就只需要关注自己的service开发，不需要关注公共业务，
 * 公共业务得到重复利用， 领域业务更加纯粹。其本质原理是动态代理的过程。此谓aop切面编程
 * Author:cbam
 * Create Date:2016/10/24
 * Modified By:
 * Modified Date:
 * Modified Reason:
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        UserService userService = (UserService) applicationContext.getBean("service");
        userService.getUser(2);
    }
}
