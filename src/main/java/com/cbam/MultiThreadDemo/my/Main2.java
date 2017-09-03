package com.cbam.MultiThreadDemo.my;

import java.util.Scanner;

/**
 * Created by ershu.liang on 2017/8/3.
 */
public class Main2 {
    public static void main(String[] args) {
        int t;
        int n, m, k;
        Scanner in = new Scanner(System.in);
        t = in.nextInt();
        n =in.nextInt();
        m = in.nextInt();
        k = in.nextInt();
        while(t-- > 0){
            in.nextLine();
            String S = in.nextLine();
            String T = in.nextLine();
            for(int i = 0; i < k; i++) {
                int L = in.nextInt();
                int R = in.nextInt();
                int begin = 0, end  = S.length() + 1;
                int mm = m;
                for(int s = 0; s < S.length(); s++) {
                    if(S.charAt(s) != T.charAt(s)) {
                        begin = s;
                        break;
                    }
                }
                for(int s =S.length() - 1; s >= 0; s--) {
                    if(S.charAt(s) != T.charAt(--mm)) {
                        end = s;
                        break;
                    }
                }
                end += 2;
                if(L < begin || R > end) {
                    System.out.println(0);
                } else {
                    double E = 1.0 / (L * (n - R + 1));
                    System.out.printf("%.0lf\n", E * L * (n - R + 1));
                }
            }
        }

    }
}
/*
1
4 3 325
abcf
abf
 */