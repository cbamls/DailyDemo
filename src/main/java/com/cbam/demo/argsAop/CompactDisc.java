package com.cbam.demo.argsAop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

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
@Component
public class CompactDisc {
    public void play() {
        System.out.println("play");
    }

    public void playTrack(int trackNumber) {
        System.out.println("trackNumber => " + trackNumber);
    }
}
