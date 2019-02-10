package com.thinkinginjava.generics.exercise.chapter15_4;

import com.thinkinginjava.generics.example.chapter15_3.coffee.Coffee;
import com.thinkinginjava.generics.example.chapter15_3.coffee.CoffeeGenerator;
import com.thinkinginjava.generics.example.chapter15_3.coffee.Generator;
import java.util.*;

/**
 * @Author: monika
 * @Date: 2019/2/3 20:39
 * @Version: 1.0
 * @Description: page 364
 * 练习13：重载fill()方法，使其参数与返回值得类型为Collection的导出类：List、Queue
 * 和Set。通过这种方式，我们就不会丢失容器的类型。能够在重载时区分List和LinkedList吗？
 */
public class Ex13 {
    static <T> Collection<T> fill(Collection<T> coll, Generator<T> gen, int n) {
        for (int i = 0; i < n; i++)
            coll.add(gen.next());
        return coll;
    }

    static <T> List<T> fill(List<T> list, Generator<T> gen, int n) {
        for (int i = 0; i < n; i++)
            list.add(gen.next());
        return list;
    }

    static <T> LinkedList<T> fill(LinkedList<T> list, Generator<T> gen, int n) {
        for (int i = 0; i < n; i++)
            list.add(gen.next());
        return list;
    }

    static <T> Queue<T> fill(Queue<T> queue, Generator<T> gen, int n) {
        for (int i = 0; i < n; i++)
            queue.add(gen.next());
        return queue;
    }

    static <T> Set<T> fill(Set<T> set, Generator<T> gen, int n) {
        for (int i = 0; i < n; i++)
            set.add(gen.next());
        return set;
    }

    public static void main(String[] args) {
        List<Coffee> coffees = fill(
                new ArrayList<>(), new CoffeeGenerator(), 4);
        for (Coffee coffee : coffees)
            System.out.println(coffee);

        LinkedList<Coffee> coffeess = fill(
                new LinkedList<>(), new CoffeeGenerator(), 4);
        for (Coffee coffee : coffees)
            System.out.println(coffee);
    }
}
/**output:
 * Americano 0
 * Latte 1
 * Americano 2
 * Mocha 3
 * Americano 0
 * Latte 1
 * Americano 2
 * Mocha 3
 */