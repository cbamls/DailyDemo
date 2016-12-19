package com.cbam.demo.javaConfigAop;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

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
@RunWith(SpringJUnit4ClassRunner.class) //加载spring上下文环境
@ContextConfiguration(classes = ConcertConfig.class) //指定配置文件
public class PerformanceTest {
    @Autowired
    Performance performance;
    @Test
    public void performance() throws Exception {
        performance.performance();
    }

}