package com.qunar;

import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by ershu.liang on 2017/10/15.
 */
class Person {
    private int id;

    private String name;

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
public class StreamsTest {
    public static void main(String[] args) {
        List<String> wordList = Lists.newArrayList("cbam", "cbam2");
        Stream<String> words = wordList.stream();
        wordList.add("END");
        //long n = words.distinct().count();
       // System.out.println(n);
        words.distinct().forEach((item) -> System.out.println(item));
//          Locale[] locale = Locale.getAvailableLocales();
//        int a = Arrays.stream(locale).mapToInt((item)  -> item.toString().length()).sum();
//        System.out.println(a);
//        Person person1 = new Person();
//        person1.setId(1);
//        person1.setName("cbam");
//        Person person2 = new Person();
//        person2.setId(2);
//        person2.setName("cbam2");
//        Stream<Person> people = Stream.of(person1, person2);
//        Map<Integer, Person> idToPerson = people.collect(
//                Collectors.toMap((Person p ) -> p.getId(), Function.identity()));
       // System.out.println(idToPerson);
    }
}
