package com.cbam.MultiThreadDemo.my;

import java.util.*;

/**
 * Created by ershu.liang on 2017/8/22.
 */
class Point {
    int x, y;
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNextInt()) {
            int n = in.nextInt();
            List<Point> list = new ArrayList<>(n + 4);
            for(int i = 0; i < n; i++) {
                int x = in.nextInt();
                int y = in.nextInt();
                list.add(new Point(x, y));
            }
            Set<Point> resList = new TreeSet<>(new Comparator<Point>() {
                @Override
                public int compare(Point o1, Point o2) {
                    return o1.x < o2.x  ? -1 : 1;
                }
            });
            for(int i = 0; i < n; i++) {
                Point pi = list.get(i);
                boolean flag = true;
                for(int j = 0; j < n; j++) {
                    Point pj = list.get(j);

                    if(pj.x > pi.x && pj.y > pi.y) {
                        flag = false;
                    }
                }
                if(flag) {
                   resList.add(pi);
                }
            }
            for(Point item : resList) {
                System.out.println(item.x + " " + item.y);
            }
        }
    }
}
/*
5
9 0
7 5
1 2
4 6
5 3

 */