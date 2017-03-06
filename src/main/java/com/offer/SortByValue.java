package com.offer;

import com.google.common.base.Preconditions;
import org.apache.tools.ant.types.resources.Sort;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Stream;

import static javafx.scene.input.KeyCode.K;
import static javafx.scene.input.KeyCode.V;

/**
 * CopyRright (c)2014-2016 Haerbin Hearglobal Co.,Ltd
 * Project: demo
 * Comments:
 * Author:cbam
 * Create Date:2017/3/5
 * Modified By:
 * Modified Date:
 * Modified Reason:
 */
public class SortByValue {

    public static Map<String, String> sortMapByValue(Map mp) {
        Preconditions.checkNotNull(mp);
        List<Map.Entry<String, String>> list = new LinkedList<>(mp.entrySet());
        Collections.sort(list, (Map.Entry<String, String> o1, Map.Entry<String, String> o2) -> {
            return -1 * o1.getValue().compareTo(o2.getValue());
        });

        Map<String, String> result = new LinkedHashMap<>();
        for(Map.Entry<String, String> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }
        return result;
    }

    public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map mp) {
        Map<K, V> result = new LinkedHashMap<K, V>();
        Stream<Map.Entry<K, V>> stream = mp.entrySet().stream();
            stream.sorted(Comparator.comparing(e -> e.getValue())).forEach(e -> result.put(e.getKey(), e.getValue()));
        return result;
    }



    public static void main(String[] args) {
//        Map mp = new HashMap();
//        mp.put("1", "4");
//        mp.put("0", "7");
//        Map result = sortByValue(mp);
//        System.out.println(result);
//        Integer[] arr = new Integer[10];
//        for(int i = 0; i < 20; i++) {
//            System.out.println(arr[i]);
//        }

        ArrayList list = new ArrayList<>();

        Iterator iter = list.iterator();
        while(iter.hasNext()) {
            iter.remove();
        }
    }
}
