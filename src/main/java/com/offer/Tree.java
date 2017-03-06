package com.offer;

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

class Node {
    public int value;
    public Node left;
    public Node right;

    public Node(int value) {
        this.value = value;
    }
}

public class Tree {

    public void preOrderRecur(Node head) {
        if(head == null) {
            return ;
        }
        System.out.println(head.value + " ");
        preOrderRecur(head.left);
        preOrderRecur(head.right);
    }

    public void inOrderRecur(Node head) {
        if(head == null) {
            return ;
        }
        inOrderRecur(head.left);
        System.out.println(head.value + " ");
        inOrderRecur(head.right);
    }
    public void afterOrderRecur(Node head) {
        if(head == null) {
            return ;
        }
        afterOrderRecur(head.left);
        afterOrderRecur(head.right);
        System.out.println(head.value + " ");

    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        Tree tree = new Tree();
        System.out.println("pre");
        tree.preOrderRecur(node1);
        System.out.println("in");
        tree.inOrderRecur(node1);
        System.out.println("after");
        tree.afterOrderRecur(node1);
    }
}
