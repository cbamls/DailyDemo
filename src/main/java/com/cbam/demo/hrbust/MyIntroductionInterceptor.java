package com.cbam.demo.hrbust;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.support.DelegatingIntroductionInterceptor;

/**
 * Created by Chris on 2017/4/6.
 */
public class MyIntroductionInterceptor extends DelegatingIntroductionInterceptor
                                       implements PerformanceMonitor{

    public static ThreadLocal<Boolean> monitorStatus = new ThreadLocal<Boolean>();

    @Override
    public void setMonitorActive(boolean active) {
        monitorStatus.set(active);
    }

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable{
        Object o = null;

        if(monitorStatus.get() != null && monitorStatus.get()){
            System.out.println("begin to monitor performance...");
            o = super.invoke(methodInvocation);
            System.out.println("end to monitor performance...");
        }else{
            o = super.invoke(methodInvocation);
        }

        return o;
    }
}
