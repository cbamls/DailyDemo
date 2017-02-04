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
public class Problem_03_ReverseStack {

    public  int getAndRemoveLastElement(Stack<Integer> stack) {
        int result = stack.pop();
        if(stack.isEmpty()) {
            return result;
        }
        int last = getAndRemoveLastElement(stack);
        stack.push(result);
        return last;
    }

    public  void reverse(Stack<Integer> stack) {
        if(stack.isEmpty()) {
            return ;
        }
        int i = getAndRemoveLastElement(stack);
        reverse(stack);
        stack.push(i);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        Problem_03_ReverseStack reverseStack = new Problem_03_ReverseStack();
        reverseStack.reverse(stack);
        while (!stack.empty()) {
            System.out.println(stack.pop());;
        }
    }
}
