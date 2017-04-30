package com.cbam.demo.hrbust;

import org.springframework.aop.framework.ProxyFactory;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Chris on 2017/3/29.
 */
public class TestSpringAOP {
    public static void main(String[] args) throws Throwable{

        // 初始化代理工厂
        ProxyFactory pf = new ProxyFactory();

        // 指定目标对象
        pf.setTarget(new ForumService());


        /**
         * 不使用切面，仅使用增强
         */
        //// 给代理工厂添加增强
        //pf.addAdvice(new MyBeforeAdvice());
        //pf.addAdvice(new MyAfterAdvice());
        //pf.addAdvice(new MyThrowsAdvice());
        //pf.addAdvice(new MyInterceptor());


        /**
         * 使用引介增强
         */
        //pf.addAdvice(new MyIntroductionInterceptor());
        //pf.setProxyTargetClass(true); // 引介增强必须通过CGLib实现
        //ForumService service = (ForumService) pf.getProxy();

        //PerformanceMonitor monitor = (PerformanceMonitor)service;

        //monitor.setMonitorActive(true);

        //service.removeTopic("topic1");
        //service.createForum();


        /**
         * 使用静态方法名切面
         */
        //// 初始化切面类
        //MyAdvisor advisor = new MyAdvisor();
        //// 给切面添加增强
        //advisor.setAdvice(new MyBeforeAdvice());
        //// 给代理工厂添加切面
        //pf.addAdvisor(advisor);


        /**
         * 使用正则表达式切面
         */
        // .*\.remove.*表示所有类中以remove开头的方法
        //RegexpMethodPointcutAdvisor advisor =
        //        new RegexpMethodPointcutAdvisor(".*\\.remove.*",new MyBeforeAdvice());
        //pf.addAdvisor(advisor);

        //// 得到代理对象，此时增强已被织入到连接点
        //ForumServiceInterface service = (ForumServiceInterface) pf.getProxy();


        //service.removeTopic("topic1");
        //service.createForum();


        /**
        * 使用动态切面
        */
        //DefaultPointcutAdvisor advisor = new DefaultPointcutAdvisor();
        //advisor.setAdvice(new MyBeforeAdvice());
        //advisor.setPointcut(new MyDynamicPointcut());

        //pf.addAdvisor(advisor);

        //ForumServiceInterface service = (ForumServiceInterface) pf.getProxy();

        //service.removeTopic("topic1");
        //service.removeTopic("topic2");
        //service.removeTopic("topic3");


        /**
         * 基于配置的AOP
         */
        AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");

        ForumServiceInterface service = (ForumServiceInterface)ctx.getBean("service");

        service.createForum();
        service.removeTopic("topic1");
        service.removeTopic("topic2");
        service.removeTopic("topic3");
    }
}
