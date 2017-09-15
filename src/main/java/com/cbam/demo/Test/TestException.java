package com.cbam.demo.Test;

import com.tinify.Exception;

/**
 * Created by ershu.liang on 2017/8/30.
 */
class User {
    int age;
}
class ExceptionCreator {
    public static void changeUser(User user) {
        user.age = 1;
    }
    public static String test(final User user) throws java.lang.Exception{
        changeUser(user);
        user.age = 10;
        System.out.println(user.age);
        return null;
    }
}
public class TestException {
    public static void main(String[] args) throws java.lang.Exception {
        User user = new User();
        user.age = 2;
        ExceptionCreator.test(user);
    }
}
