package com.thinkinginjava.enumerated_types.example.chapter19_7;

/**
 * @author: XueYing.Cao
 * @date: 2019/4/12
 * @description:
 */
public class TypeOfFood {
    public static void main(String[] args) {
        Food food = Food.Appetizer.SALAD;
        food = Food.MainCourse.LASAGNE;
        food = Food.Dessert.GELATO;
        food = Food.Coffee.CAPPUCCINO;
    }
}
