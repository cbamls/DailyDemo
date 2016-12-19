package com.cbam.demo.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * CopyRright (c)2014-2016 Haerbin Hearglobal Co.,Ltd
 * Project: demo
 * Comments:
 * Author:cbam
 * Create Date:2016/10/24
 * Modified By:
 * Modified Date:
 * Modified Reason:
 */

/*带注解的aop
* @Aspect 定义切面
*
* */
@Aspect
public class LogUserDef {
    /*配置关注点*/
    @Before("execution(* com.cbam.demo.aop.UserServiceImpl.getUser(..))")
    void before() {
        System.out.println("before");
    }
    void after() {
        System.out.println("after");
    }
    @Around("execution(* com.cbam.demo.aop.UserServiceImpl.getUser(..))")
    public Object around(ProceedingJoinPoint jp) throws Throwable {
        System.out.println("环绕前");
        System.out.println(jp.getSignature());
        System.out.println("环绕后");
        return jp.proceed();
    }

}
