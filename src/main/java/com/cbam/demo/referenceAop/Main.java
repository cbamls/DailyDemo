package com.cbam.demo.referenceAop;

import java.util.Scanner;

/**
 * Created by ershu.liang on 2017/9/14.
 */
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            long n = in.nextLong();
            long[] cnt = new long[100002];
            for (int i = 0; i < n; i++) {
                cnt[i] = in.nextLong();
            }
            long ans = 0;
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    if(i == j) {
                        continue;
                    }
                    String str = String.valueOf(cnt[i]) + String.valueOf(cnt[j]);
                    if(Long.valueOf(str) % 7 == 0) {
                        ans++;
                    }
                }
            }
            System.out.println(ans);
        }
    }
}
