package com.cbam.demo.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * CopyRright (c)2014-2016 Haerbin Hearglobal Co.,Ltd
 * Project: demo
 * Comments:
 * Author:cbam
 * Create Date:2017/2/16
 * Modified By:
 * Modified Date:
 * Modified Reason:
 */
class Node<T> {
    private Node next;

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    private T value;

    public Node(T value) {
        this.value = value;
    }
}

public class ReverseSingleList {

    /**
     * 递归反转
     * @param head
     * @return
     */
    public Node reverseList1(Node head) {
        if(head == null || head.getNext() == null) {
            return head;
        }
        Node newHead = reverseList1(head.getNext());
        head.getNext().setNext(head);
        head.setNext(null);
        return newHead;
    }

    /**
     * 遍历反转
     * @param head
     * @return
     */
    public Node reverseList2(Node head) {
        if(head == null) {
            return head;
        }
        Node pre = head;
        Node cur = head.getNext();
        Node temp;
        while(cur != null) {
            temp = cur.getNext();
            cur.setNext(pre);
            pre = cur;
            cur = temp;
        }
        head.setNext(null);
        return pre;
    }
}
