package com.cbam.demo.referenceAop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.stereotype.Component;

/**
 * CopyRright (c)2014-2016 Haerbin Hearglobal Co.,Ltd
 * Project: demo
 * Comments:EncoreableIntroducer是一个切面。但是，它与我们之前所创建的切面不同，
 *它并没有提供前置、后置或环绕通知，
 * 而是通过@DeclareParents注解，将Encoreable接口引入到Performance bean中
 * @DeclareParents注解由三部分组成：
 * value属性指定了哪种类型的bean要引入该接口。在本例中，也就是所有实现
 * Performance的类型。（标记符后面的加号表示是Performance的所有子类型，而不
 * 是Performance本身。）
 * defaultImpl属性指定了为引入功能提供实现的类。在这里，我们指定的
 * 是DefaultEncoreable提供实现。
 * @DeclareParents注解所标注的静态属性指明了要引入了接口。在这里，我们所引入
 的是Encoreable接口。
 * Author:cbam
 * Create Date:2016/12/19
 * Modified By:
 * Modified Date:
 * Modified Reason:
 */

@Aspect
public class EncoreableIntroducer {
    @DeclareParents(value = "Perform+",
            defaultImpl = DefaultEncore.class)
    public static Encoreable encoreable;
    //当Spring发现一个bean使用了@Aspect注解时，
    //Spring就会创建一个代理，然后将调用委托给被代理的bean或被引入的实现，这取决于调用的
    //  方法属于被代理的bean还是属于被引入的接口
    public EncoreableIntroducer() {
        System.out.println("被注入");
    }
}
