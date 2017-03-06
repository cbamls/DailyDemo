package com.offer;

/**
 * CopyRright (c)2014-2016 Haerbin Hearglobal Co.,Ltd
 * Project: demo
 * Comments:
 * Author:cbam
 * Create Date:2017/3/6
 * Modified By:
 * Modified Date:
 * Modified Reason:
 */
public class ReverseList {

    static class Node {
        int value;
        Node next;
        public Node(int  value) {
            this.value = value;
        }

        public Node() {

        }
    }

    public static void reverseList(Node head) {
        if(head == null) {
            return ;
        }
        Node tmp = head.next;
        while(tmp.next != null) {

        }
    }
    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        node1.next = node2;
        node2.next = node3;
        Node head = new Node();
        head.next = node1;
        reverseList(head);
    }
}
