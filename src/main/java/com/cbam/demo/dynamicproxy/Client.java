package com.cbam.demo.dynamicproxy;

import java.math.BigInteger;

/**
 * CopyRright (c)2014-2016 Haerbin Hearglobal Co.,Ltd
 * Project: demo
 * Comments:
 * Author:cbam
 * Create Date:2016/10/23
 * Modified By:
 * Modified Date:
 * Modified Reason:
 *
 * 一个动态代理类一般代理一类业务
 */
public class Client {
    public static void main(String[] args) {
        Host host = new Host();
        ProxyInovationHandler proxyInovationHandler = new ProxyInovationHandler();
        proxyInovationHandler.setRent(host);
        Rent proxy = (Rent) proxyInovationHandler.getProxy();
        proxy.rent();
    }
}
