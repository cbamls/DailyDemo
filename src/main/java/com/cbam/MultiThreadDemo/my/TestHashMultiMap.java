package com.cbam.MultiThreadDemo.my;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.TreeMultimap;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeMap;

/**
 * Created by ershu.liang on 2017/8/21.
 */
public class TestHashMultiMap {
    public static void main(String[] args) throws InterruptedException {
//        System.out.println("hashMap:");
//        HashMap<String, Integer> hashMap=new HashMap<String,Integer>();
//        hashMap.put("hadoop", 23);
//        hashMap.put("hadoop", 22);
//        hashMap.put("spark", 56);
//        hashMap.put("spark", 58);
//        hashMap.put("storm", 78);
//        hashMap.put("", 78);
//        hashMap.put(null, 78);
//        for(String demo:hashMap.keySet()){
//            System.out.println(demo+"\t"+hashMap.get(demo));
//        }
//        System.out.println("\n"+"hashMultimap:");
//        HashMultimap<String,Integer> hashMultimap = HashMultimap.create();
//        hashMultimap.put("hadoop", 23);
//        hashMultimap.put("hadoop", 22);
//        hashMultimap.put("spark", 56);
//        hashMultimap.put("spark", 58);
//        hashMultimap.put("storm", 78);
//        hashMultimap.put("", 78);
//        hashMultimap.put(null, 78);
//        for(String demo:hashMultimap.keySet()){
//            System.out.println(demo+"\t"+hashMultimap.get(demo));
//        }
//
//        System.out.println("\n"+"HashSet:");
//        HashSet<String> hashSet = new HashSet<>();
//        hashSet.add("hadoop");
//        hashSet.add("hadoop");
//        hashSet.add("spark");
//        hashSet.add("spark");
//        hashSet.add("storm");
//        hashSet.add("abc");
//        hashSet.add("");
//        hashSet.add(null);
//        for(String str:hashSet ){
//            System.out.println(str);
//        }
//
//        System.out.println("\n"+"TreeMap:");
//        TreeMap<String,Integer> treeMap = new TreeMap<String,Integer>();
//        treeMap.put("hadoop", 23);
//        treeMap.put("hadoop", 22);
//        treeMap.put("spark", 56);
//        treeMap.put("spark", 58);
//        treeMap.put("storm", 78);
//        treeMap.put("hive", 34);
//        treeMap.put("kafka", 87);
//        treeMap.put("", 78);
//        //treeMap.put(null, 78);  //key不能为null
//        for(String demo:treeMap.keySet()){
//            System.out.println(demo+"\t"+treeMap.get(demo));
//        }
//
//        System.out.println("\n"+"TreeMultimap:");
//        TreeMultimap<String,Integer> treeMultimap = TreeMultimap.create();
//        treeMultimap.put("hadoop", 23);
//        treeMultimap.put("hadoop", 22);
//        treeMultimap.put("spark", 56);
//        treeMultimap.put("spark", 58);
//        treeMultimap.put("storm", 78);
//        treeMultimap.put("hive", 34);
//        treeMultimap.put("kafka", 87);
//        treeMultimap.put("", 78);
//        //treeMultimap.put(null, 78);  //key不能为null
//        for(String demo:treeMultimap.keySet()){
//            System.out.println(demo+"\t"+treeMultimap.get(demo));
//        }
//        ThreadLocal<Integer> seqNum = new ThreadLocal<Integer>();
//        seqNum.set(1);
//        seqNum.set(2);
//        while (true) {
//            System.out.println(seqNum.get());
//            Thread.sleep(1000000);
//        }
        String str = "test";
        System.out.println(testMethod(str));;
        System.out.println(str);
    }

    static String testMethod(String str) {
        return str + "cbam";
    }
}