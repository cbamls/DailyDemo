package com.cbam.demo.Test;

import org.springframework.web.servlet.HttpServletBean;

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
class DoubleNode<T> {
    private T value;
    private DoubleNode<T> last;
    private DoubleNode<T> next;
    public DoubleNode(T data) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public DoubleNode<T> getLast() {
        return last;
    }

    public void setLast(DoubleNode<T> last) {
        this.last = last;
    }

    public DoubleNode<T> getNext() {
        return next;
    }

    public void setNext(DoubleNode<T> next) {
        this.next = next;
    }
}
public class DoubleReverseList<T> {

    public DoubleNode<T> reverseList(DoubleNode<T> head) {
        DoubleNode<T> pre = null;
        DoubleNode<T> next = null;
        while(head != null) {
            next = head.getNext();
            head.setNext(pre);
            head.setLast(next);
            pre = head;
            head = next;
        }
        return pre;
    }
}
