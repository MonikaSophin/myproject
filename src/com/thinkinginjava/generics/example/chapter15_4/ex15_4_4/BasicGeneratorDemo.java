package com.thinkinginjava.generics.example.chapter15_4.ex15_4_4;

import com.thinkinginjava.util.Generator;

/**
 * @Author: monika
 * @Date: 2019/2/4 16:36
 * @Version: 1.0
 * @Description:
 */
public class BasicGeneratorDemo {
    public static void main(String[] args) {
        Generator<CountedObject> gen = BasicGenrator.create(CountedObject.class);
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