package com.thinkinginjava.enumerated_types.example.chapter19_7;

/**
 * @author: XueYing.Cao
 * @date: 2019/4/12
 * @description:
 */
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
