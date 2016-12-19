package com.cbam.demo.argsAop;

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
//@ComponentScan  如果放开这句  那么就没必要采用手动装配 同时启用反而会报错
public class CDPlayerConfig {
    @Bean
    public CompactDisc getDisc() {
        CompactDisc cd = new CompactDisc();
        return cd;
    }
    @Bean
    public TrackCounter trackCounter() {
        return new TrackCounter();
    }
}
