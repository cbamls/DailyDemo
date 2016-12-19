package com.cbam.demo.referenceAop;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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
//@ContextConfiguration(locations = { "classpath*:spring-ctx-application.xml",
//"classpath*:spring-ctx-consumer.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:beans.xml"})
public class PerformanceTest {
    @Autowired
    Perform performance;

    @Test
    public void performance() throws Exception {
        performance.performance();
        Encoreable encoreable = (Encoreable)performance;
        encoreable.performEncore();
    }

}