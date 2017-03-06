package com.offer;

import java.util.Arrays;
import java.util.List;

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
public class FindTwoListJoinPoint {

    private static class ListNode {
        private int val;

        private ListNode next;

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode node) {
            this.val = val;
            this.next = node;
        }

    }


   public static ListNode findTwoListJoinPoin(ListNode head) {
       if(head == null) {
           return null;
       }
       ListNode slow = head, fast = head;
    return  null;
   }


    public static void main(String[] args) {

    }
}
