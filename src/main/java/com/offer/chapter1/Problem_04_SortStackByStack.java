package com.offer.chapter1;

import java.util.ArrayList;
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
public class Problem_04_SortStackByStack {
    public static void sortStackByStack(Stack<Integer> stack) {
        Stack<Integer> help = new Stack<>();
        while(!stack.isEmpty()) {
            int cur = stack.pop();
            while(!help.isEmpty() && help.peek() > cur) {
                stack.push(help.pop());
            }
            help.push(cur);
        }

        while(!help.isEmpty()) {
            stack.push(help.pop());
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(2);
        stack.push(1);
        stack.push(3);
        Problem_04_SortStackByStack.sortStackByStack(stack);
        while (!stack.empty()) {
            System.out.println(stack.pop());
        }
    }

}
