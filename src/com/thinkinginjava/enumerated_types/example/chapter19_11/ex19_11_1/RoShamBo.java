package com.thinkinginjava.enumerated_types.example.chapter19_11.ex19_11_1;

import com.thinkinginjava.util.Enums;

/**
 * @author: XueYing.Cao
 * @date: 2019/4/16
 * @description:
 */
public class RoShamBo {
    public static <T extends Competitor<T>> void match(T a, T b) {
        System.out.println(String.format("%s vs. %s : %s", a, b , a.compete(b)));
    }

    public static <T extends Enum<T> & Competitor<T>> void play(Class<T> rsbClass, int size) {
        for (int i = 0; i < size; i++)
            match(Enums.random(rsbClass), Enums.random(rsbClass));
    }
}
