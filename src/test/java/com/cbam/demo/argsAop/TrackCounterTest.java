package com.cbam.demo.argsAop;

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
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = CDPlayerConfig.class)
public class TrackCounterTest {
    @Autowired
    private TrackCounter trackCounter;

    @Autowired
    private CompactDisc cd;
    @Test
    public void testTrackCounter() {
        cd.playTrack(1);
        cd .playTrack(2);
        System.out.println("res => " + trackCounter.getPlayCount(1));
    }
}