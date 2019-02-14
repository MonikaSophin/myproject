package com.thinkinginjava.generics.example.chapter15_10.ex15_10_1;

import com.thinkinginjava.generics.example.chapter15_10.model.Apple;
import com.thinkinginjava.generics.example.chapter15_10.model.Fruit;
import java.util.Arrays;
import java.util.List;

/**
 * @author: XueYing.Cao
 * @date: 2019/2/14
 * @description:
 */
public class CompilerIntelligence {
    public static void main(String[] args) {
        List<? extends Fruit> flists = Arrays.asList(new Apple());
        Apple a = (Apple)flists.get(0);
        flists.contains(new Apple()); // 参数为‘Object’
        flists.indexOf(new Apple());// 参数为‘Object’
    }
}
