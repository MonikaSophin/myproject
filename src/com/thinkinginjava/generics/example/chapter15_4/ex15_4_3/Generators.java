package com.thinkinginjava.generics.example.chapter15_4.ex15_4_3;

import com.thinkinginjava.generics.example.chapter15_3.Fibonacci;
import com.thinkinginjava.generics.example.chapter15_3.coffee.Coffee;
import com.thinkinginjava.generics.example.chapter15_3.coffee.CoffeeGenerator;
import com.thinkinginjava.generics.example.chapter15_3.coffee.Generator;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @Author: monika
 * @Date: 2019/2/3 20:33
 * @Version: 1.0
 * @Description:
 */
public class Generators {
    public static <T> Collection<T> fill(Collection<T> coll, Generator<T> gen, int n) {
        for (int i = 0; i < n; i++)
            coll.add(gen.next());
        return coll;
    }

    public static void main(String[] args) {
        Collection<Coffee> coffees = fill(
                new ArrayList<>(), new CoffeeGenerator(), 4);
        for (Coffee coffee : coffees)
            System.out.println(coffee);
        Collection<Integer> fnumbers = fill(
                new ArrayList<Integer>(), new Fibonacci(), 12);
        for (Integer fnumber : fnumbers)
            System.out.print(fnumber + ", ");
    }
}
/**output:
 * Americano 0
 * Latte 1
 * Americano 2
 * Mocha 3
 * 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144,
 */