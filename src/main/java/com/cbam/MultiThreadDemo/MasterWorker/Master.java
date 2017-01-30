package com.cbam.MultiThreadDemo.MasterWorker;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
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
public class Master {

    //承装任务的集合
    private ConcurrentLinkedQueue<Task> workerQueue = new ConcurrentLinkedQueue<>();
    // 承装所有的worker对象
    private HashMap<String , Thread> workers  = new HashMap<>();
    //承装所有worker的结果集
    private ConcurrentHashMap<String, Object> resultMap = new ConcurrentHashMap<>();

    public Master(Worker worker, int workerCount) {
        worker.setWorkerQueue(this.workerQueue);
        worker.setResultMap(this.resultMap);
        for(int i = 0; i < workerCount; i++) {
            workers.put("子节点" + Integer.toString(i), new Thread(worker));
        }
    }
    //提交任务的方法
    public void submit(Task task) {
        this.workerQueue.add(task);
    }

    //启动程序让所有worker工作
    public void execute() {
        for(Map.Entry<String, Thread>each : workers.entrySet()) {
            each.getValue().start();
        }
    }

    //判断线程是否执行完毕
    public boolean isComplete() {
        for(Map.Entry<String, Thread>each : workers.entrySet()) {
            if(each.getValue().getState() != Thread.State.TERMINATED) {
                return false;
            }
        }
        return true;
    }

    //返回结果集
    public Object getResult() {
        return this.resultMap;
    }
}
