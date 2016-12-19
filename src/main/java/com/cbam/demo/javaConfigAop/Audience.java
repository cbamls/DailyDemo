package com.cbam.demo.javaConfigAop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * CopyRright (c)2014-2016 Haerbin Hearglobal Co.,Ltd
 * Project: demo
 * Comments:
 * Author:cbam
 * Create Date:2016/12/19
 * Modified By:
 * Modified Date:
 * Modified Reason:
 */
@Aspect //定义这个类是通知
public class Audience {

    @Pointcut("execution(* Performance.performance(..))")
    public void performance() {} //这个东西只是配置切点时依附的一个东西

    @Before("performance()")
    public void silenceCellPhones() {
        System.out.println("前置通知");
    }

    @AfterReturning("performance()")
    public void applause() {
        System.out.println("后置通知");
    }

    @Around("performance()")
    public void watchPerformance(ProceedingJoinPoint pj) {

        try {
            System.out.println("环绕通知");
            long start = System.currentTimeMillis();
            long end = System.currentTimeMillis();
            pj.proceed();//如果不调用此方法会阻塞对被通知方法的调用
            System.out.println("around " + pj + " Use time : " + (end - start) + " ms!");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }
    @AfterThrowing("performance()")
    public void demandRefund() {
        System.out.println("退钱");
    }
}
