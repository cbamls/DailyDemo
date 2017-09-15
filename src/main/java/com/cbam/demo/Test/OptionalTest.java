package com.cbam.demo.Test;


import com.google.common.base.Function;
import com.google.common.base.Functions;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.LinkedListMultimap;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by ershu.liang on 2017/9/4.
 */
public class OptionalTest {
    public static void main(String[] args) {
        List<Object> list = new ArrayList<>();
        list.add("a");
        list = null;
//        Integer a = null;
//        HashMap mp = new HashMap();
//        mp.put("a", 1);
//        ListMultimap lm = ArrayListMultimap.create();
//        lm.put("1", 2);
//        lm.put("1", 3);
//        System.out.println(lm.get(1));
//        List<Integer> list1 = Lists.transform(list, Functions.forMap(mp));
        Preconditions.checkArgument(true==true);
        System.out.println(Optional.fromNullable(list).or(new ArrayList<>()));
    }
}
