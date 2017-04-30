package com.cbam.demo.hrbust;
class ListNode {
        int val;
         ListNode next;
         ListNode(int x) {
                 val = x;
                 next = null;
            }
}
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode newNode = new ListNode(0);
        ListNode node = newNode;
        int cap = 0;
        while(l1 != null && l2 != null) {
            int val = l1.val + l2.val + cap;
            cap = val / 10;
            node.next = new ListNode(val % 10);
            l1 = l1.next;
            l2 = l2.next;
            node = node.next;
        }
        if(cap != 0) {
            node.next = new ListNode(cap);
        }
        return newNode.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(0);
        ListNode node2 = new ListNode(1);
        ListNode newNode = new Solution().addTwoNumbers(node1, node2);
        System.out.println();;
    }
}