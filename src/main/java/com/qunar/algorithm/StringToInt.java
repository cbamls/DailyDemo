package com.qunar.algorithm;

/**
 * Created by ershu.liang on 2017/8/25.
 */
public class StringToInt {
    public static void main(String[] args) {
        String str = "123";
        int ans = 0;
        for(int i = 0; i < str.length(); i++) {
            ans = ans * 10 + str.charAt(i)  - '0';
        }
        System.out.println(ans);
    }
}
