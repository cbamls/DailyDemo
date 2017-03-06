package com.offer;

import java.util.HashMap;
import java.util.Map;

/**
 * CopyRright (c)2014-2016 Haerbin Hearglobal Co.,Ltd
 * Project: demo
 * Comments:
 * Author:cbam
 * Create Date:2017/3/4
 * Modified By:
 * Modified Date:
 * Modified Reason:
 */
public class LRUCache {

    class Node {
        Node pre;
        Node next;
        Integer key;
        Integer value;

        Node(Integer k, Integer v) {
            this.key = k;
            this.value = v;
        }
    }

    Map<Integer, Node> mp = new HashMap<>();

    Node head;

    Node tail;

    int cap;

    public LRUCache(int capacity) {
        cap = capacity;
        head = new Node(null, null);
        tail = new Node(null, null);
        head.next = tail;
        tail.pre = head;
    }

//    public int get(int key) {
//
//    }
//
//    private void moveToTail(Node node) {
//
//    }
}
