package com.cbam.demo.dynamicproxy;

import com.qunar.proxy.Tran;

/**
 * CopyRright (c)2014-2016 Haerbin Hearglobal Co.,Ltd
 * Project: demo
 * Comments:
 * Author:cbam
 * Create Date:2016/10/23
 * Modified By:
 * Modified Date:
 * Modified Reason:
 */
public class Host implements Rent{
    @Tran
    public void rent() {
        System.out.println("去租房");
    }
}
