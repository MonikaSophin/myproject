package com.thinkinginjava.generics.exercise.chapter15_4;

import com.thinkinginjava.generics.example.chapter15_3.coffee.Generator;
import com.thinkinginjava.generics.example.chapter15_4.ex15_4_4.BasicGenrator;
import com.thinkinginjava.generics.example.chapter15_4.ex15_4_4.CountedObject;

/**
 * @Author: monika
 * @Date: 2019/2/4 16:39
 * @Version: 1.0
 * @Description: page 365
 * 练习14：修改BasicGeneratorDemo.java类，使其显式地构造Generator(也就是不使用
 * create()方法，而是使用显式地构造器)。
 */
public class Ex14 {
    public static void main(String[] args) {
        Generator<CountedObject> gen = new BasicGenrator<>(CountedObject.class);
        for (int i = 0; i < 5; i++)
            System.out.println(gen.next());
    }
}
/**output:
 * CounterObject 0
 * CounterObject 1
 * CounterObject 2
 * CounterObject 3
 * CounterObject 4
 */