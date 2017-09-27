package com.cbam.demo.Test;

/**
 * Created by ershu.liang on 2017/9/1.
 */
public class TestStati {
    Person person = new Person("Test", 5);

    static {
        System.out.println("test static");
    }

    public TestStati() {
        System.out.println("test constructor");
    }

    public static void main(String[] args) {
        new MyClass();
    }
}

class Person {
    static {
        System.out.println("person static");
    }
    private int a;
    public Person(String str, int a) {
        this.a = a;
        System.out.println("person " + str);
    }
}

class MyClass extends TestStati {

    Person person = new Person("MyClass", 5);

    static {
        System.out.println("myclass static");
    }

    public MyClass() {
        System.out.println("myclass constructor");
    }
}