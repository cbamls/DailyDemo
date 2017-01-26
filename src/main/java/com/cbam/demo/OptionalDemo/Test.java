package com.cbam.demo.OptionalDemo;

import java.util.Optional;
import java.util.function.IntConsumer;

/**
 * CopyRright (c)2014-2016 Haerbin Hearglobal Co.,Ltd
 * Project: demo
 * Comments:
 * Author:cbam
 * Create Date:2017/1/15
 * Modified By:
 * Modified Date:
 * Modified Reason:
 */

public class Test {
    public static Optional<Double> squareRoot(Double x) {
        return x < 0 ? Optional.empty() : Optional.of(Math.sqrt(x));
    }
    public static Optional<Double> inverse(Double x) {
        return x == 0 ? Optional.empty() : Optional.of(1 / x);
    }

    void threeTimes(IntConsumer r) {
        for (int i = 0; i < 3; i++) {
            r.accept(i);
        }
    }

    void demo() {
        threeTimes(i -> {
            System.out.println(i);
            return; // Return from lambda to threeTimes only!
        });
    }

    public static void main(String[] args) {
//        Optional<Double> result = Optional.of(4.0).flatMap(Test::inverse).flatMap(Test::squareRoot);
//        result.ifPresent(System.out:: println);
        new Test().demo();
    }


}