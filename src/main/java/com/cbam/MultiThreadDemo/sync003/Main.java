package com.cbam.MultiThreadDemo.sync003;

import java.util.Scanner;

/**
 * Created by ershu.liang on 2017/8/22.
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNextInt()) {
            int n = in.nextInt();
            int[] arr = new int[n];
            for(int i = 0; i < n; i++) {
                int a = in.nextInt();
                arr[i] = a;
            }
            int ans = -Integer.MAX_VALUE;
            for(int i = 0; i < n; i++) {
                int Min = arr[i];
                int sum = 0;
                for(int j = i; j < n; j++) {
                    sum += arr[j];
                    Min = Math.min(Min, arr[j]);
                    ans = Math.max(sum * Min, ans);
                    //System.out.println(sum + " " + Min + " " + ans);
                }
            }
            System.out.println(ans);
        }
    }
}
/*
3
6 2 1
 */