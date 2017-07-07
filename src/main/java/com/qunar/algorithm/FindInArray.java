package com.qunar.algorithm;

import java.lang.reflect.Array;
import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;

/**
 * Created by ershu.liang on 2017/7/6.
 */
public class FindInArray {
    public boolean Find(int target, int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] == target) {
                    return true;
                }
            }
        }
        return false;
    }


    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public class BinNode {
        BinNode left;
        BinNode right;

        int val;
        public BinNode() {
        }
    }

//    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
//        List<Integer> list = new LinkedList<>();
//        if(listNode == null) {
//            return null;
//        }
//        while(listNode.next != null) {
//            list.add(listNode.val);
//            listNode = listNode.next;
//        }
//       list.
//    }

    public boolean findElement(int[][] arr, int rows, int columns, int target) {
        int row = 0;
        int column = columns - 1;
        while (row < rows && column >= 0) {
            if (arr[row][column] == target) {
                return true;
            } else if (arr[row][column] > target) {
                column--;
            } else {
                row++;
            }
        }
        return false;
    }

    public static char[] replaceBlank(char arr[], int length) {
        int originLength = length;
        int totalNumber = 0;
        for (int i = 0; i < originLength; i++) {
            if (arr[i] == ' ') {
                totalNumber++;
            }
        }
        int finalLength = originLength + totalNumber * 2 - 1;
        for (int i = originLength - 1; i >= 0; i--) {
            if (arr[i] == ' ') {
                arr[finalLength--] = '0';
                arr[finalLength--] = '2';
                arr[finalLength--] = '%';
            } else {
                arr[finalLength--] = arr[i];
            }
        }
        return arr;
    }

    public void reversePrintList(ListNode listNode) {

        if (listNode != null) {
            if (listNode.next != null) {
                reversePrintList(listNode.next);
            }
            System.out.println(listNode.val);
        }
    }

    public class MockQueue {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        public void appendTail(int val) {
            stack1.push(val);
        }

        public int getFirst() {
            if (stack2.isEmpty()) {
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
                if (!stack2.isEmpty()) {
                    return stack2.pop();
                }
            }
            return stack2.pop();
        }
    }

    public static long Fibonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return Fibonacci(n - 1) + Fibonacci(n - 2);
    }

    public static void dfsDigit(int n) {
        if (n < 0) {
            return;
        }
        char[] arr = new char[n + 13];
        dfs(arr, n, 3, 0);
    }

    public static void dfs(char[] arr, int n, int len, int index) {
        if (index == 3) {
            System.out.println(arr);
            return;
        }
        for (int i = 0; i < n; i++) {
            arr[index] = (char) (i + '0');
            dfs(arr, n, len, index + 1);
        }
    }

    public static void deleteNode(ListNode target, ListNode head) {

        if (target == null || head == null) {
            return;
        }
        if (head == target) {
            head = null;
            target = null;
        } else {
            if (target.next != null) {
                target.val = target.next.val;
                target.next = target.next.next;
                target.next = null;
            } else {
                ListNode tmpNode = head;
                while (tmpNode.next != target) {
                    tmpNode = tmpNode.next;
                }
                tmpNode.next = null;
                target = null;
            }
        }
    }

    public static void moveArray(int[] arr) {
        int pFront = 0;
        int pEnd = arr.length - 1;
        while (pFront < pEnd) {
            while (pFront < pEnd && arr[pFront] % 2 != 0) {
                pFront++;
            }
            while (pFront < pEnd && arr[pFront] % 2 == 0) {
                pEnd--;
            }
            arr[pEnd] = arr[pEnd] ^ arr[pFront];
            arr[pFront] = arr[pEnd] ^ arr[pFront];
            arr[pEnd] = arr[pEnd] ^ arr[pFront];
        }
    }

    public static ListNode findToTail(ListNode head, int k) {
        if (head == null || k == 0) {
            return null;
        }
        ListNode pAhead = head;
        ListNode pBehind = head;
        for (int i = 0; i < k - 1; i++) {
            if (pAhead.next != null) {
                pAhead = pAhead.next;
            } else {
                return null;
            }
        }
        while (pAhead.next != null) {
            pBehind = pBehind.next;
            pAhead = pAhead.next;
        }
        return pBehind;
    }

    private static Stack<Integer> minStack = new Stack();
    private static Stack<Integer> myStack = new Stack();

    public static void stackWithMinPush(int n) {
        myStack.push(n);
        if (minStack.size() == 0 || minStack.peek() > n) {
            minStack.push(n);
        } else {
            minStack.push(minStack.peek());
        }
    }

    public static int stackWithMinPop() {
        minStack.pop();
        return myStack.pop();
    }


    public static int stackWithMin() {
        return minStack.pop();
    }

    public static ListNode reverseList(ListNode head) {
        ListNode preNode = null;
        ListNode curNode = head;
        ListNode newHead = null;
        while (curNode != null) {
            ListNode nextNode = curNode.next;
            if (nextNode == null) {
                newHead = curNode;
            }
            curNode.next = preNode;
            preNode = curNode;
            curNode = nextNode;
        }
        return newHead;
    }

    public static void printFromTopToBottom(BinNode root) {
        if (root == null) {
            return;
        }
        Queue<BinNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            BinNode rt = queue.poll();
            System.out.println(rt.val);
            if(rt.left != null) {
                queue.add(rt.left);
            } else {
                queue.add(rt.right);
            }
        }
    }
    public static void permutation(String str){
        int count=0;
        if(str==null)
            return;
        char[] chs=str.toCharArray();
        int point=0;
        System.out.print(chs);
        System.out.print(" ");
        count++;
        char temp1=chs[point];
        chs[point]=chs[++point];
        chs[point]=temp1;
        while(!String.valueOf(chs).equals(str)){
            System.out.print(chs);
            System.out.print(" ");
            count++;
            if(point==chs.length-1){
                char temp=chs[point];
                chs[point]=chs[0];
                chs[0]=temp;
                point=0;
            }else{
                char temp=chs[point];
                chs[point]=chs[++point];
                chs[point]=temp;
            }
        }
        System.out.println(count);
    }

    public static void permutation2(String str) {
        char[] arr = str.toCharArray();
        toPermutation(arr, 0);
    }

    public static void toPermutation(char[] arr, int index) {
        if(index == arr.length - 1) {
            System.out.println(arr);

            return ;
        }
        for(int i = index; i < arr.length; i++) {
            char tmp = arr[index];
            arr[index] = arr[i];
            arr[i] = tmp;
            toPermutation(arr, index  + 1);
            tmp = arr[index];
            arr[index] = arr[i];
            arr[i] = tmp;
        }
    }

    public static ListNode mergeList(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null) {
            return pHead2;
        }
        if (pHead2 == null) {
            return pHead1;
        }
        if (pHead1.val < pHead2.val) {
            pHead1.next = mergeList(pHead1.next, pHead2);
        }

        return null;
    }

    public static int treeDepth(BinNode root) {
        if(root == null) {
            return 0;
        }
        int left = treeDepth(root.left);
        int right = treeDepth(root.right);
        return left > right ?  left + 1 : right;
    }

    public static boolean isBalanced(BinNode root,  int len) {
        if(root ==  null) {

        }
        return false;
    }

    public static void add(int a) {
        a++;
    }

    public static int testAdd(int a) {
        add(a);
        return a;
    }
    public static void main(String[] args) {
//        char[] arr = new char[10];
//        arr[0] = '1';
//        arr[1] = '2';
//        arr[2] = ' ';
//        arr[3] = '3';
//        System.out.println(replaceBlank(arr, 4));
        //       dfsDigit(3);
        //System.out.println((3 & 0x1) == 0);
//        permutation2("123");
        System.out.println(testAdd(2));;
    }
}
