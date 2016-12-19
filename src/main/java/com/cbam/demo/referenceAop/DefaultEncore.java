package com.cbam.demo.referenceAop;

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

public class DefaultEncore implements Encoreable {
    public void performEncore() {
        System.out.println("默认实现");
    }
}
