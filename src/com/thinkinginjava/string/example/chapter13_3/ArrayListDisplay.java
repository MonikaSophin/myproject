package com.thinkinginjava.string.example.chapter13_3;

import com.thinkinginjava.string.example.chapter13_3.coffee.Coffee;
import com.thinkinginjava.string.example.chapter13_3.coffee.CoffeeGenerator;
import java.util.ArrayList;

/**
 * @Author: monika
 * @Date: 2018/12/31 15:07
 * @Version: 1.0
 * @Description:
 */
public class ArrayListDisplay {
    public static void main(String[] args) {
        ArrayList<Coffee> coffees = new ArrayList<>();
        for (Coffee c : new CoffeeGenerator(10))
            coffees.add(c);
        System.out.println(coffees);
    }
}
/**output:
 * [Americano 0, Latte 1, Americano 2, Mocha 3, Mocha 4, Breve 5, Americano 6, Latte 7, Cappuccino 8, Cappuccino 9]
 */