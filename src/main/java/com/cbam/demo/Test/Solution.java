package com.cbam.demo.Test;

import java.util.HashMap;
import java.util.Map;

class Point {
    int x;
    int y;
    Point() { x = 0; y = 0; }
    Point(int a, int b) { x = a; y = b; }
}

public class Solution {

    public int maxPoints(Point[] points) {
        if(points.length <= 2) {
            return points.length;
        }

        int res = 0;

        for(Point p : points) {
            int x = p.x;
            int y = p.y;
            int V = 0, L = 1;
            HashMap<Float, Integer> mp = new HashMap<Float, Integer>();
            for(Point p2 : points) {
                if(!p.equals(p2)) {
                    int x2 = p2.x;
                    int y2 = p2.y;
                    if(x == x2) {
                        if(y == y2) {
                            L++;
                        } else {
                            V++;
                        }
                    }

                    Float k = getSlope(x, y, x2, y2);
                    if(!mp.containsKey(k)) {
                        mp.put(k, 1);
                    } else {
                        int pre = mp.get(k);
                        mp.put(k, ++pre);
                    }

                }


            }
            int Max = V;
            for(Map.Entry<Float, Integer> entry : mp.entrySet()) {
                Max = Math.max(Max, entry.getValue());
            }
            res = Math.max(res, Max + L);

        }


        return res;
    }

    private Float getSlope(int x, int y, int x2, int y2) {
        return (float)(1.0 * (y - y2) / (x - x2));
    }

    public static void main(String[] args) {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(1, 1);
        Point p3 = new Point(1, -1);

        System.out.println(new Solution().maxPoints(new Point[]{p1, p2, p3}));
    }
}