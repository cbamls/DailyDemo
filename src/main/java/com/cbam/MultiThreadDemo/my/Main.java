package com.cbam.MultiThreadDemo.my;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.*;

public class Main {

/** 请完成下面这个函数，实现题目要求的功能 **/
    /** 当然，你也可以不按照这个模板来作答，完全按照自己的想法来 ^-^  **/
//    static int maxScore(int[] score) {
//        boolean[] flag = new boolean[score.length];
//        int res = 0;
//        int len = score.length;
//        while(len > 0) {
//            if(len % 2 != 0) {
//                int k = 0;
//                int i = 0;
//                for(i = 0; ; i++) {
//                    if(!flag[i]) {
//                        k++;
//                        if(k == len / 2) {
//                            break;
//                        }
//                    }
//                }
//                res += (score[i - 1] + score[i]
//            }
//        }
//    }
    //
    static int maxScore(int[] score) {
        int res = 0;
        int len = score.length;
        while(len > 2) {
            if(len % 2 != 0) {
               res += score[len / 2 - 1] * score[len / 2 - 2] * score[len/2];
                resizeScore(len / 2, len,  score);
            } else {
                if(score[len / 2 - 1] > score[len / 2]) {
                    res += score[len / 2 - 1] * score[len / 2] * score[len/2 +1];
                    resizeScore(len / 2, len, score);
                } else {
                    res += score[len / 2 - 2] * score[len / 2 - 1] * score[len/2];
                    resizeScore(len / 2 - 1, len, score);
                }
            }
        }
        res += (score[0] * score[1] + score[0] > score[1] ? score[0] : score[1]) ;
        return res;
    }

    private static void resizeScore(int mid, int len, int[] score) {
        for(int i = mid; i < len - 1; i++) {
            score[i] = score[i + 1];
        }
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int res;
        int _score_size = 0;
        _score_size = Integer.parseInt(in.nextLine().trim());
        int[] _score = new int[_score_size];
        int _score_item;
        for(int _score_i = 0; _score_i < _score_size; _score_i++) {
            _score_item = Integer.parseInt(in.nextLine().trim());
            _score[_score_i] = _score_item;
        }

        res = maxScore(_score);
        System.out.println(String.valueOf(res));

    }
}