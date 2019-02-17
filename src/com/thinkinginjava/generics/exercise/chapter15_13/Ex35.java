package com.thinkinginjava.generics.exercise.chapter15_13;

import com.thinkinginjava.generics.example.chapter15_3.coffee.Americano;
import com.thinkinginjava.generics.example.chapter15_3.coffee.Breve;
import com.thinkinginjava.generics.example.chapter15_3.coffee.Coffee;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author: monika
 * @Date: 2019/2/17 21:42
 * @Version: 1.0
 * @Description: page 410
 * 练习35：修改CheckedList.java，使其使用本章中定义的Coffee类。
 */
public class Ex35 {
    @SuppressWarnings("unchecked")
    static void coffee(List list) {
        list.add(new Americano());
    }

    public static void main(String[] args) {
        List<Breve> breves1 = new ArrayList<>();
        coffee(breves1);

        List<Breve> breves2 = Collections.checkedList(
                new ArrayList<>(), Breve.class);
        try {
            coffee(breves2);
        }catch (Exception e) {
            System.out.println(e);
        }

        List<Coffee> coffees = new ArrayList<>();
        coffees.add(new Americano());
        coffees.add(new Breve());
    }
}
/**output:
 * java.lang.ClassCastException: Attempt to insert class
 *  com.thinkinginjava.generics.example.chapter15_3.coffee.Americano
 *  element into collection with element type class
 *  com.thinkinginjava.generics.example.chapter15_3.coffee.Breve
 */