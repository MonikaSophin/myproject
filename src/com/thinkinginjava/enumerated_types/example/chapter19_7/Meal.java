package com.thinkinginjava.enumerated_types.example.chapter19_7;

/**
 * @author: XueYing.Cao
 * @date: 2019/4/12
 * @description:
 */
public class Meal {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            for (Course course : Course.values()) {
                Food food = course.randomSelection();
                System.out.println(food);
            }
            System.out.println("------");
        }
    }
}
/**output:
 * SPRING_ROLLS
 * PAD_THAI
 * FRUIT
 * DECAF_COFFEE
 * ------
 * SOUP
 * PAD_THAI
 * FRUIT
 * TEA
 * ------
 * SALAD
 * BURRID
 * FRUIT
 * TEA
 * ------
 * SALAD
 * BURRID
 * CREME_CARAMEL
 * LATTE
 * ------
 * SOUP
 * BURRID
 * TIRAMISU
 * ESPREESSO
 * ------
 */