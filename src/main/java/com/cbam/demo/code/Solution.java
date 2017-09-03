package com.cbam.demo.code;

import com.offer.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * CopyRright (c)2014-2016 Haerbin Hearglobal Co.,Ltd
 * Project: demo
 * Comments:
 * Author:cbam
 * Create Date:2017/4/6
 * Modified By:
 * Modified Date:
 * Modified Reason:
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class Solution {

    public boolean isBalenced(TreeNode root) {
        if(root == null) {
            return true;
        }
        int left = depth(root.left);
        int right = depth(root.right);
        if(left - right > 1 || left - right < -1) {
            return false;
        } else {
            return isBalenced(root.left) && isBalenced(root.right);
        }
    }

    private int depth(TreeNode n) {
        if(n == null) {
            return 0;
        }
        if(n.left == null && n.right == null) {
            return 1;
        } else {
            int left = depth(n.left);
            int right = depth(n.right);
            return 1 + (Math.max(left, right));
        }
    }


    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode root = new ListNode(0);
        ListNode p = root;
        root.next = head;

        for(int i = 0; i < m; i++) {
            p = p.next;
        }
        if(p != null) {
            ListNode q = p.next;
            ListNode r;
            if(m < 1) {
                m = 1;
            }
            n = n - m + 1;
            for(int i = 1; i < n && q.next != null; i++) {
                r = q.next;
                q.next = r.next;
                r.next = p.next;
                p.next = r;
            }

            head = root.next;
        }
        return head;
    }


    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> result = new LinkedList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode node = root;
        while(node != null || !stack.isEmpty()) {
            while(node != null) {
                stack.addLast(node);
                node = node.left;
            }

            if(!stack.isEmpty()) {
                node = stack.removeLast();
                result.add(node.val);
                node = node.right;
            }
        }
        System.out.println(result);
        return result;
    }

    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(slow == fast) {
                break;
            }
        }
        return !(fast == null || fast.next == null);
    }

    public List<Character> reverseWord(int step) {
        String str = "1234";
        List<Character> list = new ArrayList<>();
        if(step == 3) {
            list.add(str.charAt(step));
            return list;
        }
        List<Character> res = reverseWord(++step);
        list.addAll(res);
        list.add(str.charAt(--step));
        return list;
    }

    public static void main(String[] args) {
//        TreeNode node1 = new TreeNode(1);
//        TreeNode node2 = new TreeNode(2);
//        TreeNode node3 = new TreeNode(3);
//        node1.left = node2;
//        node1.right = node3;
//        new Main2().inorderTraversal(node1);
          List<Character> list =  new Solution().reverseWord(0);

        System.out.println(list);
    }
}
