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
public class Problem_01_MyStack1 {
    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;

    public Problem_01_MyStack1() {
        this.stackData = new Stack<>();
        this.stackMin = new Stack<>();
    }

    public int getMin() {
        if(this.stackMin.isEmpty()) {
            throw new RuntimeException("Your stack is empty");
        }
        return this.stackMin.peek();
    }
    public void push(int newNum) {
        if(this.stackMin.isEmpty()) {
            this.stackMin.push(newNum);
        } else if(newNum <= this.getMin()) {
            this.stackMin.push(newNum);
        }
        this.stackData.push(newNum);
    }

    public int pop() {
        if(this.stackData.isEmpty()) {
            throw new RuntimeException("Your stack is empty");
        }
        int value = this.stackData.pop();
        if(value == this.getMin()) {
            this.stackMin.pop();
        }
        return value;
    }
}
