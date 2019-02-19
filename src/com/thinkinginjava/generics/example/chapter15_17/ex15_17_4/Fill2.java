package com.thinkinginjava.generics.example.chapter15_17.ex15_17_4;

import com.thinkinginjava.generics.example.chapter15_17.ex15_17_2.SimpleQueue;
import com.thinkinginjava.generics.example.chapter15_3.coffee.Coffee;
import com.thinkinginjava.generics.example.chapter15_3.coffee.Generator;
import com.thinkinginjava.generics.example.chapter15_3.coffee.Latte;
import com.thinkinginjava.generics.example.chapter15_3.coffee.Mocha;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author: XueYing.Cao
 * @date: 2019/2/19
 * @description:
 */
interface Addable<T> { void add(T t); }

public class Fill2 {
    // Classtoken版本:
    public static <T> void fill(Addable<T> addable, Class<? extends T> classToken, int size) {
        for (int i = 0; i < size; i++) {
            try {
                addable.add(classToken.newInstance());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
    //Generator版本：
    public static <T> void fill(Addable<T> addable, Generator<T> generator, int size) {
        for (int i = 0; i < size; i++)
            addable.add(generator.next());
    }
}

//要适应基类型，必须使用组合。使用组合使任何集合都可添加
class AddableCollectionAdapter<T> implements Addable<T> {
    private Collection<T> c;
    public AddableCollectionAdapter(Collection<T> c) { this.c = c; }
    @Override
    public void add(T t) { c.add(t); }
}

//自动捕获类型的帮助程序
class Adapter {
    public static <T> Addable<T> collectionAdapter(Collection<T> c) {
        return new AddableCollectionAdapter<>(c);
    }
}

//要适应特定类型，可以使用继承。使用继承使SimpleQueue可添加
class AddableSimpleQueue<T> extends SimpleQueue<T> implements Addable<T> {
    @Override
    public void add(T t) { super.add(t); }
}

class Fill2Test {
    public static void main(String[] args) {
        List<Coffee> carrier = new ArrayList<>();
        Fill2.fill(new AddableCollectionAdapter<>(carrier), Coffee.class, 3);
        Fill2.fill(Adapter.collectionAdapter(carrier), Latte.class, 2);
        for (Coffee c : carrier)
            System.out.println(c);
        System.out.println("----------------------");

        AddableSimpleQueue<Coffee> coffeeQueue = new AddableSimpleQueue<>();
        Fill2.fill(coffeeQueue, Mocha.class, 4);
        Fill2.fill(coffeeQueue, Latte.class, 1);
        for (Coffee c : coffeeQueue)
            System.out.println(c);
    }
}
/**output:
 * Coffee 0
 * Coffee 1
 * Coffee 2
 * Latte 3
 * Latte 4
 * ----------------------
 * Mocha 5
 * Mocha 6
 * Mocha 7
 * Mocha 8
 * Latte 9
 */