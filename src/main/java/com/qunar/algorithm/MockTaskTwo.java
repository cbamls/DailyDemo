package com.qunar.algorithm;

import com.sun.org.apache.xpath.internal.functions.FuncTrue;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * Created by ershu.liang on 2017/7/12.
 */
public class MockTaskTwo {
    private static List<TreeNode> nodeList = new LinkedList<>();
    private static Vector<Integer>[] vt = new Vector[1000];

    static class TreeNode implements Callable {
        int val;
        int id;
        int parentId;

        public TreeNode(int val, int id, int parentId) {
            this.val = val;
            this.id = id;
            this.parentId = parentId;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", id=" + id +
                    ", parentId=" + parentId +
                    '}';
        }

        @Override
        public Object call() throws Exception {
            System.out.println("cal");
            int rtn = 0;
            if(vt[this.id] == null) {
                return this.val;
            }
            for(int i = 0; i < vt[this.id].size();  i++) {
                TreeNode node = nodeList.get(vt[this.id].get(i));
                FutureTask<Integer> future = new FutureTask<Integer>(node);
                future.run();
                int result = future.get();
                rtn = Math.max(rtn, result + this.val);
            }
            return rtn;
        }
    }

    public void addNode(TreeNode node) {
        nodeList.add(node);
        int m = nodeList.size();
        if (vt[node.parentId] == null) {
            vt[node.parentId] = new Vector<Integer>();
        }
        vt[node.parentId].add(m - 1);
    }

    public static void main(String[] args) {
        MockTaskTwo mtt = new MockTaskTwo();
        Scanner in = new Scanner(System.in);
        TreeNode root = new TreeNode(0, 0, 0);
        mtt.addNode(root);
        mtt.vt[0] = new Vector<>(1000);
        while (in.hasNext()) {
            String tx = in.nextLine();
            if (tx.equals("eof")) {
                break;
            }
            String subTx = tx.substring(1, tx.length() - 1);
            String arr[] = subTx.split(",");
            TreeNode node = new TreeNode(Integer.parseInt(arr[2].trim()), Integer
                    .parseInt(arr[0].trim()), Integer.parseInt(arr[1].trim()));
            mtt.addNode(node);
        }
        FutureTask<Integer> future = new FutureTask<Integer>(root);
        future.run();
        try {
            System.out.println(future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
/*
(1, 0, 2)
(3, 1, 2)
(4, 1, 3)
(5, 4, 1)
(6, 3, 3)
eof

 */