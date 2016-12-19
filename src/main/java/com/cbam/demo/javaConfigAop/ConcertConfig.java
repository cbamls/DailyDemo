package com.cbam.demo.javaConfigAop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

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
@Configuration
@EnableAspectJAutoProxy
@ComponentScan
public class ConcertConfig {
    /**
     * 利用javaConfig来指定要自动装配的bean
     * 此处的bean是定义通知的bean
     * @return
     */
    @Bean
    public Audience audience() {
        return new Audience();
    }
    @Bean
    public Performance performance() {
        return new Performance();
    }
}
