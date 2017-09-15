package com.cbam.demo.Test;

import java.util.*;

/**
 * Created by ershu.liang on 2017/8/25.
 */
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int n = in.nextInt();
            int[] cnt = new int[100002];
            boolean flag = true;
            for (int i = 0; i < n; i++) {
                cnt[i] = in.nextInt();
                if(cnt[i] == 1 && flag) {
                    cnt[i] = 0;
                    flag = false;
                } else  if(cnt[i] == 0 && !flag) {
                    flag = true;
                }
            }
            if (!flag) {
                System.out.println("Alice");
            } else {
                System.out.println("Bob");
            }
        }
    }
}
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        String str = in.nextLine();
//        int k = in.nextInt();
//        Set<Long> st = new TreeSet<>();
//        for (String item : str.split(" ")) {
//            if(item.trim().equals("")) {
//                continue;
//            }
//            st.add(Long.valueOf(item.trim()));
//        }
//        System.out.println(st.toArray()[st.size() - k]);
//    }

//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int[] arr = new int[100003];
//        int[] ans = new int[100003];
//        int co1 = 0;
//        String str = in.nextLine();
//        for(String item : str.split(" ")) {
//            arr[co1] = Integer.valueOf(item);
//            if(arr[co1] < 0) {
//                ans[co1] = 0;
//            } else {
//                ans[co1]= arr[co1];
//            }
//            co1++;
//        }
//        int res = arr[0];
//        for(int i = 1; i < co1; i++) {
//            if(ans[i - 1] > 0) {
//                ans[i] = ans[i - 1] + arr[i];
//                res = Math.max(res, ans[i]);
//            }
//        }
//        System.out.println(res);
//    }
/*
-23 17 -7 11 -2 1 -34
 */