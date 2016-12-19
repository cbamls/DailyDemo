package com.cbam.demo.argsAop;

import org.springframework.beans.factory.annotation.Autowired;

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
public class CDPlayer implements MediaPlayer {
    private CompactDisc compactDisc;

    @Autowired
    public CDPlayer(CompactDisc cd) {
        this.compactDisc = cd;
    }
    public void play() {
        compactDisc.play();
    }
}
