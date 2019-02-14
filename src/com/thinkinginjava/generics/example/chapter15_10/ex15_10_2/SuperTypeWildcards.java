package com.thinkinginjava.generics.example.chapter15_10.ex15_10_2;

import com.thinkinginjava.generics.example.chapter15_10.model.Apple;
import com.thinkinginjava.generics.example.chapter15_10.model.Fruit;
import com.thinkinginjava.generics.example.chapter15_10.model.Jonathan;

import java.util.List;

/**
 * @author: XueYing.Cao
 * @date: 2019/2/14
 * @description:
 */
public class SuperTypeWildcards {
    static void writeTo(List<? super Apple> apples) {
        apples.add(new Apple());
        apples.add(new Jonathan());
        //! apples.add(new Fruit()); //Error
    }
}
