package com.thinkinginjava.enumerated_types.exercise.chapter19_7;

import com.thinkinginjava.enumerated_types.example.chapter19_7.Course;
import com.thinkinginjava.enumerated_types.example.chapter19_7.Food;
import com.thinkinginjava.enumerated_types.example.chapter19_7.Meal;
import com.thinkinginjava.util.Enums;

/**
 * @author: XueYing.Cao
 * @date: 2019/4/12
 * @description: page 600
 * 练习03：向{@link Course}中添加一个新的Course,证明它在{@link Meal}中能正确工作。
 */
enum Course3 {
    APPETIZER(Food3.Appetizer.class),
    MAINCOURSE(Food3.MainCourse.class),
    DESSERT(Food3.Dessert.class),
    COFFEE(Food3.Coffee.class),
    TEA(Food3.TEA.class);

    private Food[] values;
    Course3(Class<? extends Food> kind) {
        values = kind.getEnumConstants();
    }
    public Food randomSelection() {
        return Enums.random(values);
    }

    interface Food3 extends Food {
        enum TEA implements Food3 {
            RED_TEA, GRREN_TEA, BLACK_TEA
        }
    }
}

public class Ex03 {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            for (Course3 course : Course3.values()) {
                Food food = course.randomSelection();
                System.out.println(course + ": " + food);
            }
            System.out.println("------");
        }
    }
}
/**output:
 * APPETIZER: SPRING_ROLLS
 * MAINCOURSE: PAD_THAI
 * DESSERT: FRUIT
 * COFFEE: DECAF_COFFEE
 * TEA: GRREN_TEA
 * ------
 * APPETIZER: SPRING_ROLLS
 * MAINCOURSE: BURRID
 * DESSERT: TIRAMISU
 * COFFEE: TEA
 * TEA: GRREN_TEA
 * ------
 * APPETIZER: SALAD
 * MAINCOURSE: LASAGNE
 * DESSERT: GELATO
 * COFFEE: DECAF_COFFEE
 * TEA: BLACK_TEA
 * ------
 * APPETIZER: SOUP
 * MAINCOURSE: BURRID
 * DESSERT: GELATO
 * COFFEE: BLACK_COFFEE
 * TEA: GRREN_TEA
 * ------
 * APPETIZER: SOUP
 * MAINCOURSE: LASAGNE
 * DESSERT: GELATO
 * COFFEE: BLACK_COFFEE
 * TEA: BLACK_TEA
 * ------
 */