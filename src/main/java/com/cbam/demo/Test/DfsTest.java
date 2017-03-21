package com.cbam.demo.Test;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.util.ObjectUtils;
import org.springframework.web.context.ContextLoaderListener;

import java.util.concurrent.locks.ReentrantLock;

/**
 * CopyRright (c)2014-2016 Haerbin Hearglobal Co.,Ltd
 * Project: demo
 * Comments:
 * Author:cbam
 * Create Date:2017/3/13
 * Modified By:
 * Modified Date:
 * Modified Reason:
 */
public class DfsTest {

    private int count = 0;
    private int[] arr = new int[] {1, 2,3 ,4};
    private boolean vis[] = new boolean[20];
    private int[] box = new int[4];
    public void dfs(int step) {
        if(this.count == 4) {
            return ;
        }
        for(int i = 0; i < arr.length; i++) {
            if(!vis[i]) {
                vis[i] = true;
                box[i] = arr[i];
                dfs(step);
                vis[i] = false;
            }
        }
    }

    public static void main(String[] args) {
    }
}
