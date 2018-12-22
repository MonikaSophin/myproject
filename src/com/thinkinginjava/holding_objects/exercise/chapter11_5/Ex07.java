package com.thinkinginjava.holding_objects.exercise.chapter11_5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: monika
 * @Date: 2018/12/13 23:02
 * @Version: 1.0
 * @Description: page 226
 * 练习07：创建一个类，然后创建一个用你的类的对象进行过初始化的数组。通过使用
 * subList()方法，创建你的List的子集，然后在你的List中移除这个子集。
 */
class Clazz07{
    private int num;
    public Clazz07(int num) { this.num = num; }
    @Override
    public String toString() {
        return "Clazz07{" +
                "num=" + num +
                '}';
    }
}

public class Ex07 {
    public static void main(String[] args) {
        System.out.println("Array:");
        Clazz07[] clazz07s = new Clazz07[]{new Clazz07(0),
                new Clazz07(1),new Clazz07(2),
                new Clazz07(3),new Clazz07(4)};
        for (Clazz07 clazz07: clazz07s)
            System.out.print(clazz07 + " ");
        System.out.println();

        System.out.println("List:");
        List<Clazz07> lists = new ArrayList<>(Arrays.asList(clazz07s));
        for (Clazz07 clazz07: lists)
            System.out.print(clazz07 + " ");
        System.out.println();


        System.out.println("SubList:");
        List<Clazz07> subs = lists.subList(0, 3);
        for (Clazz07 clazz07:subs)
            System.out.print(clazz07 + " ");
        System.out.println();


        System.out.println("List remove SubList:");
        lists.removeAll(subs);
        for (Clazz07 clazz07:lists)
            System.out.print(clazz07 + " ");
    }
}
/**输出：
 * Array:
 * Clazz07{num=0} Clazz07{num=1} Clazz07{num=2} Clazz07{num=3} Clazz07{num=4}
 * List:
 * Clazz07{num=0} Clazz07{num=1} Clazz07{num=2} Clazz07{num=3} Clazz07{num=4}
 * SubList:
 * Clazz07{num=0} Clazz07{num=1} Clazz07{num=2}
 * List remove SubList:
 * Clazz07{num=3} Clazz07{num=4}
 */