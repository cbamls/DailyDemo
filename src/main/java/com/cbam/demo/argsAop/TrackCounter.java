package com.cbam.demo.argsAop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

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
@Aspect
public class TrackCounter {
    private Map<Integer, Integer> trackCount = new HashMap<Integer, Integer>();
     @Pointcut("execution(* CompactDisc.playTrack(int)) " + "&& args(trackNumber)")
     public void trackPlayed(int trackNumber){}

    @Before("trackPlayed(trackNumber)")
    public void countTrack(int trackNumber) {
        int currentCount = getPlayCount(trackNumber);
        trackCount.put(trackNumber, currentCount);
    }

    public int getPlayCount(int trackNumber) {
        return trackCount.containsKey(trackNumber) ? trackCount.get(trackNumber) + 1: 0;
    }

}
