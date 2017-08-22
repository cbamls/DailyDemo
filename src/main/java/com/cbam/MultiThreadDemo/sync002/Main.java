package com.cbam.MultiThreadDemo.sync002;

import java.util.Comparator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by ershu.liang on 2017/8/22.
 */
class Idea {
    int id;
    int startTime;
    int priority;
    int spentTime;

    public Idea(int id, int startTime,  int priority, int spentTime) {
        this.id = id;
        this.startTime = startTime;
        this.spentTime = spentTime;
        this.priority = priority;
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNextInt()) {
            Set<Idea> st = new TreeSet<>(new Comparator<Idea>() {
                @Override
                public int compare(Idea o1, Idea o2) {

                    if(o1.priority == o2.priority) {
                        if(o1.spentTime == o2.spentTime) {
                            if(o1.startTime == o2.startTime) {
                                if(o1.id == o2.id) {
                                    return 0;
                                }
                                return o1.id > o2.id ? 1 : -1;
                            }
                            return o1.startTime > o2.startTime ? 1 : -1;
                        }
                        return o1.spentTime > o2.spentTime ? 1 : -1;
                    }
                    return o1.priority > o2.priority ? -1 : 1;
                }
            });
            int n = in.nextInt();
            int m = in.nextInt();
            int p = in.nextInt();
            for(int i = 0; i < p; i++) {
                int a = in.nextInt();
                int b = in.nextInt();
                int c = in.nextInt();
                int d = in.nextInt();
                st.add(new Idea(a, b,  c, d));
                //TODO make a wrong answers
                System.out.println(b + d);
            }

        }
    }
}
/*
2 2 5
1 1 1 2
1 2 1 1
1 3 2 2
2 1 1 2
2 3 5 5
 */