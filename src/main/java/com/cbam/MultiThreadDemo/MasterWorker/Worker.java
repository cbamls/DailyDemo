package com.cbam.MultiThreadDemo.MasterWorker;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * CopyRright (c)2014-2016 Haerbin Hearglobal Co.,Ltd
 * Project: demo
 * Comments:
 * Author:cbam
 * Create Date:2017/1/30
 * Modified By:
 * Modified Date:
 * Modified Reason:
 */
public class Worker implements Runnable {
    private ConcurrentLinkedQueue workerQueue;
    private ConcurrentHashMap resultMap;

    private Object handle(Task input) {
        Object output = null;
        try {
            Thread.sleep(500);
            output = input.getPrice();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return output;
    }
    @Override
    public void run() {
        while (true) {
            Task input = (Task) this.workerQueue.poll();
            if(input == null) {
                break;
            }
            Object output = handle(input);
            this.resultMap.put(Integer.toString(input.getId()), output);
        }
    }

    public ConcurrentHashMap getResultMap() {
        return resultMap;
    }

    public void setResultMap(ConcurrentHashMap resultMap) {
        this.resultMap = resultMap;
    }

    public ConcurrentLinkedQueue getWorkerQueue() {
        return workerQueue;
    }

    public void setWorkerQueue(ConcurrentLinkedQueue workerQueue) {
        this.workerQueue = workerQueue;
    }
}
