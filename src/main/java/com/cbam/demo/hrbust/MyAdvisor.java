package com.cbam.demo.hrbust;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.StaticMethodMatcherPointcutAdvisor;

import java.lang.reflect.Method;

/**
 * Created by Chris on 2017/3/29.
 */
public class MyAdvisor extends StaticMethodMatcherPointcutAdvisor {

    @Override
    public boolean matches(Method method, Class<?> aClass) {
        boolean ret = false;

        ret = method.getName().equals("removeTopic");

        return ret;
    }

    public ClassFilter getClassFilter(){
        return new ClassFilter(){
            public boolean matches(Class<?> cls){
                boolean ret = false;

                ret = cls.getSimpleName().equals("ForumService");

                return ret;
            }
        };
    }


}
