package com.qunar.algorithm;

import java.util.*;

/**
 * Created by ershu.liang on 2017/7/12.
 */
public class SingleTask {

    private static final int MAX_VER = 1000;

    private Vector<Edge> edges = new Vector<>();

    private static Vector<Integer> G[] = new Vector[MAX_VER];

    private static HashMap<Integer, Integer> spendMap = new HashMap<>();

    private int res;

    class Node {

    }

    class Edge {
        int from;
        int to;

        public Edge(int from, int to) {
            this.from = from;
            this.to = to;
        }

        public Edge() {
        }
    }

    public void addEdge(int from, int to, int val) {
        spendMap.put(to, val);
        if (from == to || from == 0) {
            return;
        }
        edges.add(new Edge(from, to));
        int m = edges.size();
        if(G[from] == null) {
            G[from] = new Vector<>();
        }
        G[from].add(m - 1);

    }

    public void dfs(Integer root, Integer val) {

        if (G[root] == null || G[root].size() == 0) {
            res = Math.max(val, res);
            return ;
        }
        for (int i = 0; i < G[root].size(); i++) {
            Edge e = edges.get(G[root].get(i));
            dfs(e.to, val + spendMap.get(e.to));
        }
    }

    public static void main(String[] args) {
        SingleTask singleTask = new SingleTask();
        Scanner in = new Scanner(System.in);
        Set<Integer> rootSet = new HashSet<>();
        while (in.hasNext()) {
            String tx = in.nextLine();
            if(tx.equals("eof")) {
                break;
            }
            String subTx = tx.substring(1, tx.length() - 1);
            String arr[] = subTx.split(",");
            if (arr[1].trim().equals("0")) {
                rootSet.add(Integer.parseInt(arr[0]));
            }
            //System.out.println(arr[0] + " " + arr[1] + " " + arr[2]);
            singleTask.addEdge(Integer.parseInt(arr[1].trim()), Integer.parseInt(arr[0].trim()), Integer.parseInt(arr[2].trim()));
        }
        System.out.println("root = > " + rootSet.size());
        for(Integer each : rootSet) {
            System.out.println("value = >" +  each + " " + singleTask.spendMap.get(each));
            singleTask.dfs(each, singleTask.spendMap.get(each));
        }
        System.out.println("res = > " + singleTask.res);
    }
}
/*
(1, 0, 2)
(3, 1, 2)
(4, 1, 3)
eof

*/