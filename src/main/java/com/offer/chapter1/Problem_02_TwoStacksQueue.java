package com.offer.chapter1;

import java.util.Stack;

/**
 * CopyRright (c)2014-2016 Haerbin Hearglobal Co.,Ltd
 * Project: demo
 * Comments:
 * Author:cbam
 * Create Date:2017/2/4
 * Modified By:
 * Modified Date:
 * Modified Reason:
 */
public class Problem_02_TwoStacksQueue {
    private Stack<Integer> stackPush;
    private Stack<Integer> stackPop;

    public Problem_02_TwoStacksQueue() {
        stackPush = new Stack<>();
        stackPop = new Stack<>();
    }

    public void add(int pushInt) {
        stackPush.push(pushInt);
    }

    public int poll() {
        if(stackPop.empty() && stackPush.empty()) {
            throw new RuntimeException("Queue is empty");
        } else if(stackPop.empty()) {
            while(!stackPush.empty()) {
                stackPop.push(stackPush.pop());
            }
        }
        return stackPop.pop();
    }

    public int peek() {
        if(stackPop.empty() && stackPush.empty()) {
            throw new RuntimeException("Queue is empty");
        } else if(stackPop.empty()) {
            while(!stackPush.empty()) {
                stackPop.push(stackPush.pop());
            }
        }
        return this.stackPop.peek();
    }
}
