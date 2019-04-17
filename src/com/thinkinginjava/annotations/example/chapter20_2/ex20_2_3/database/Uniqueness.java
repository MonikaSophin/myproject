package com.thinkinginjava.annotations.example.chapter20_2.ex20_2_3.database;

/**
 * @author: XueYing.Cao
 * @date: 2019/4/17
 * @description:
 */
public @interface Uniqueness {
    Constraints constraints() default @Constraints(unique = true);
}
