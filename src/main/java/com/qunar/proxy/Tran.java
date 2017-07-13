package com.qunar.proxy;

import java.lang.annotation.*;

/**
 * Created by ershu.liang on 2017/7/12.
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Inherited
public @interface Tran {

}