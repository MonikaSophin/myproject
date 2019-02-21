package com.thinkinginjava.type_information.exercise.chapter14_3;

import com.thinkinginjava.type_information.exercise.chapter14_3.coffee.*;
import com.thinkinginjava.util.TypeCounter;

/**
 * @Author: monika
 * @Date: 2019/1/26 18:20
 * @Version: 1.0
 * @Description: page 331
 * 练习12;将第15章中的CoffeeGenerator.java类用于TypeCounter。
 */
public class Ex12 {
    private static Coffee[] coffees = { new Latte(), new Mocha(),
    new Cappuccino(), new  Americano(), new  Breve()};
    public static void main(String[] args) {
        TypeCounter counter = new TypeCounter(Coffee.class);
        for (Coffee type : coffees) {
            System.out.print(type.getClass().getSimpleName() + " ");
            counter.count(type);
        }
        System.out.println();
        System.out.println(counter);
    }
}
/**output:
 * Latte Mocha Cappuccino Americano Breve
 * {Coffee=5, Cappuccino=1, Latte=1, Breve=1, Mocha=1, Americano=1}
 */