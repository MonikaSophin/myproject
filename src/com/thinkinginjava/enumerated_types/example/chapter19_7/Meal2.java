package com.thinkinginjava.enumerated_types.example.chapter19_7;

import com.thinkinginjava.util.Enums;

/**
 * @author: XueYing.Cao
 * @date: 2019/4/12
 * @description:
 */
public enum Meal2 {
    APPETIZER(Food.Appetizer.class),
    MAINCOURSE(Food.MainCourse.class),
    DESSERT(Food.Dessert.class),
    COFFEE(Food.Coffee.class);

    private Food[] values;
    Meal2(Class<? extends Food> kind) {
        this.values = kind.getEnumConstants();
    }
    public Food randonSelection() {
        return Enums.random(values);
    }

    public interface Food {
        enum Appetizer implements Food {
            SALAD, SOUP, SPRING_ROLLS;
        }
        enum MainCourse implements Food {
            LASAGNE, BURRID, PAD_THAI
        }
        enum Dessert implements Food {
            TIRAMISU, GELATO, BLACK_FORESR_FCAKE,
            FRUIT, CREME_CARAMEL
        }
        enum Coffee implements Food {
            BLACK_COFFEE, DECAF_COFFEE, ESPREESSO,
            LATTE, CAPPUCCINO, TEA, HERB_TREA
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            for (Meal2 meal : Meal2.values()) {
                Food food = meal.randonSelection();
                System.out.println(meal + ": " + food);
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
 * ------
 * APPETIZER: SOUP
 * MAINCOURSE: PAD_THAI
 * DESSERT: FRUIT
 * COFFEE: TEA
 * ------
 * APPETIZER: SALAD
 * MAINCOURSE: BURRID
 * DESSERT: FRUIT
 * COFFEE: TEA
 * ------
 * APPETIZER: SALAD
 * MAINCOURSE: BURRID
 * DESSERT: CREME_CARAMEL
 * COFFEE: LATTE
 * ------
 * APPETIZER: SOUP
 * MAINCOURSE: BURRID
 * DESSERT: TIRAMISU
 * COFFEE: ESPREESSO
 * ------
 */