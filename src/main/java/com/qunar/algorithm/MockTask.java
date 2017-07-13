package com.qunar.algorithm;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

/**
 * Created by ershu.liang on 2017/7/12.
 */
public class MockTask {
    private static List<TreeNode> nodeList = new LinkedList<>();
    private static Vector<Integer>[] vt = new Vector[1000];

    private int res;

    static class TreeNode {
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
    }

    public void addNode(TreeNode node) {
        nodeList.add(node);
        int m = nodeList.size();
        if (vt[node.parentId] == null) {
            vt[node.parentId] = new Vector<Integer>();
        }
        vt[node.parentId].add(m -1);
    }

    static class MapTask extends RecursiveTask<Integer> {
        private TreeNode currentNode;

        public MapTask(TreeNode currentNode) {
            this.currentNode = currentNode;
        }

        @Override
        protected Integer compute() {
            int rtn = 0;
            if (vt[currentNode.id] == null) {
                return currentNode.val;
            } else {
                for (int i = 0; i < vt[currentNode.id].size(); i++) {
                    MapTask mt = new MapTask(nodeList.get(vt[currentNode.id].get(i)));
                    mt.fork();
                    int result = mt.join();
                    rtn = Math.max(rtn, result + currentNode.val);
                }
            }
            return rtn;
        }
    }

    public static void main(String[] args) {
        MockTask mockTask = new MockTask();
        Scanner in = new Scanner(System.in);
        mockTask.addNode(new TreeNode(0, 0, 0));
        mockTask.vt[0] = new Vector<>(1000);
        while (in.hasNext()) {
            String tx = in.nextLine();
            if (tx.equals("eof")) {
                break;
            }
            String subTx = tx.substring(1, tx.length() - 1);
            String arr[] = subTx.split(",");
            TreeNode node = new TreeNode(Integer.parseInt(arr[2].trim()), Integer
                    .parseInt(arr[0].trim()), Integer.parseInt(arr[1].trim()));
            mockTask.addNode(node);
        }
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        MapTask task = new MapTask(new TreeNode(0, 0, 0));
        Future<Integer> result = forkJoinPool.submit(task);
        try {
            System.out.println(result.get());
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
eof

*/