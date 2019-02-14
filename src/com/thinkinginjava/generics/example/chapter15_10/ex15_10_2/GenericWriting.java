package com.thinkinginjava.generics.example.chapter15_10.ex15_10_2;

import com.thinkinginjava.generics.example.chapter15_10.model.Apple;
import com.thinkinginjava.generics.example.chapter15_10.model.Fruit;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: XueYing.Cao
 * @date: 2019/2/14
 * @description:
 */
public class GenericWriting {
    static List<Apple> apples = new ArrayList<>();
    static List<Fruit> fruits = new ArrayList<>();

    // 准确的类型
    static <T> void writeExact(List<T> list, T item) { list.add(item); }
    // 含有通配符?
    static <T> void writeWithWildcard(List<? super T> list, T item) { list.add(item); }

    static void f1() {
        writeExact(apples, new Apple());
        writeExact(fruits, new Apple());
    }
    static void f2() {
        writeWithWildcard(apples, new Apple());
        writeWithWildcard(fruits, new Apple());
    }

    public static void main(String[] args) {
        f1();
        f2();
    }
}
//~