package com.thinkinginjava.enumerated_types.example.chapter19_7;

import com.thinkinginjava.util.Enums;

/**
 * @author: XueYing.Cao
 * @date: 2019/4/12
 * @description:
 */
public enum Course {
    APPETIZER(Food.Appetizer.class),
    MAINCOURSE(Food.MainCourse.class),
    DESSERT(Food.Dessert.class),
    COFFEE(Food.Coffee.class);

    private Food[] values;
    Course(Class<? extends Food> kind) {
        values = kind.getEnumConstants();
    }
    public Food randomSelection() {
        return Enums.random(values);
    }
}
