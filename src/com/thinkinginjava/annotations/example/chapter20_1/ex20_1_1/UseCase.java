package com.thinkinginjava.annotations.example.chapter20_1.ex20_1_1;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author: XueYing.Cao
 * @date: 2019/4/17
 * @description:
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface UseCase {
    public int id();
    String description() default "no description";
}
