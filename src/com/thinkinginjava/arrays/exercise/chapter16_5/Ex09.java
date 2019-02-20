package com.thinkinginjava.arrays.exercise.chapter16_5;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: XueYing.Cao
 * @date: 2019/2/20
 * @description: page 442
 * 练习09：创建Peel<Banana>所必需的类，并展示编译器不会接受它。使用ArrayList来
 * 改正此问题。
 */
class Banana {
    private static long counter;
    private final long id = counter++;
    public String toString() { return "Banana-" + id; }
}

class Peel<T> {
    private T t;
    private static long counter;
    private final long id = counter++;
    public Peel(T t) { this.t = t; }
    public String toString() { return "Peel-" + id + " " + t.toString(); }
}

public class Ex09<T> {
    public static void main(String[] args) {
        // 编译错误：泛型数组创建:
        // Peel<Banana>[] peels = new Peel<Banana>[10];

        List<Peel<Banana>> peels = new ArrayList<>();
        for(int i = 0; i < 5; i++)
            peels.add(new Peel<>(new Banana()));
        System.out.println(peels);
        System.out.println("peels.get(0).getClass(): " + peels.get(0).getClass());
    }
}
/**output:
 * [Peel-0 Banana-0, Peel-1 Banana-1, Peel-2 Banana-2, Peel-3 Banana-3, Peel-4 Banana-4]
 * peels.get(0).getClass(): class com.thinkinginjava.arrays.exercise.chapter16_5.Peel
 */