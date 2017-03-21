package com.cbam.demo.Test;

import javafx.util.Pair;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * CopyRright (c)2014-2016 Haerbin Hearglobal Co.,Ltd
 * Project: demo
 * Comments:
 * Author:cbam
 * Create Date:2017/3/14
 * Modified By:
 * Modified Date:
 * Modified Reason:
 */
public class DocSearchTest {

//    public static void getMinSubList() {
//        int total = 0;
//        HashMap<String, Integer> mp = new HashMap();
//        HashMap<Integer, Pair<HashMap<String, Integer> , Integer>> hm = new HashMap<>();
//        for(int i = 0; i <= doc.length - query.length; i++) {
//            if(doc[i].equals(query[0])) {
//                hm.put(++total, new Pair<>(new HashMap<String, Integer>(){{putAll(mp);}}, 0));
//            } else if(doc[i].equals(query[query.length - 1])) {
//              for(int j = 0; j < total; j++) {
//                  boolean flag = true;
//                  Pair<HashMap<String, Integer> , Integer> pair = hm.get(j);
//                  for(Map.Entry<String, Integer> entry : checkMap.entrySet()) {
//                      if()
//                  }
//              }
//            } else {
//                for(int j = 0; j < total; j++) {
//                    Pair<HashMap<String, Integer> , Integer> pair = hm.get(j);
//                    HashMap<String, Integer> map = pair.getKey();
//                    int val = map.get(doc[i]);
//                    if(val >= 1) {
//                        map.put(doc[i], --val);
//                    } else {
//                        int value = pair.getValue();
//
//                    }
//                }
//            }
//        }
//    }
//
//    private static int MIN = 0x1f1f1f1f;
////    //
//    private static String doc[];
//
//    private static String query[];
//    private static HashMap<String, Integer> mp = new HashMap();
////    private static int l, r;
////    private static void getMinSubList() {
////        int total = 0;
////        while(true) {
////            while(r < doc.length && total != query.length) {
////                if(mp.containsKey(doc[r])) {
////                    int val = mp.get(doc[r]);
////                    mp.put(doc[r], ++val);
////                    if(val == 1) {
////                        total++;
////                    }
////                }
////                r++;
////
////            }
////            MIN = Math.min(MIN, r - l);
////            if(mp.containsKey(doc[l])) {
////                int val = mp.get(doc[l]);
////                mp.put(doc[l], --val);
////                if(val == 0) {
////                    total--;
////                }
////                l++;
////            }
////            if(l + query.length > doc.length) {
////                break;
////            }
////        }
////    }
////
    public static void main(String[] args) {
//        doc = new String[]{"q1", "w1", "w2", "q1", "q1", "q5","w3", "q5"};
//        query = new String[]{"q1", "q4"};
//        mp.put("q1", 0);
//        mp.put("q5", 0);

        Integer a = 3;
        Integer b = 3;
        a++;
        a--;
        List<String> list = new ArrayList<String>(){{add("1");add("2");}};
        String[] tmp = new String[list.size()];
        tmp = list.toArray(tmp);
        System.out.println(tmp);


    }

}
