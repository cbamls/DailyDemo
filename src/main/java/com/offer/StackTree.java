package com.offer;

import java.util.Stack;

/**
 * CopyRright (c)2014-2016 Haerbin Hearglobal Co.,Ltd
 * Project: demo
 * Comments:
 * Author:cbam
 * Create Date:2017/3/5
 * Modified By:
 * Modified Date:
 * Modified Reason:
 */

public class StackTree {

    public void preOrderUnRecur(Node head) {
        System.out.println("pre-order");
        if(head != null) {
            Stack<Node> stack = new Stack();
            stack.push(head);
            while(!stack.isEmpty()) {
                head = stack.pop();
                System.out.println(head.value);
                if(head.right != null) {
                    stack.push(head.right);
                }
                if(head.left != null) {
                    stack.push(head.left);
                }
            }
        }
    }

    public void inOrderUnRecur(Node head) {
        System.out.println("in-order");
        if(head != null) {
            Stack<Node> stack = new Stack<>();
            while(!stack.isEmpty() || head != null) {
                if(head != null) {
                    stack.push(head);
                    head = head.left;
                } else {
                    head = stack.pop();
                    System.out.println(head.value + " ");
                    head = head.right;
                }
            }
        }
    }

    public static Integer getNum() {
        Integer a = 1;
        try {
            return a;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            a = 2;
            System.out.println("finally a = " + a);
        }
        return 0;
    }
    public static void main(String[] args) {
        System.out.println(getNum());
    }
}
