package com.design_mode.creational_patterns.factory_pattern.simple_factory;

import com.design_mode.creational_patterns.factory_pattern.model.Chocolate;
import com.design_mode.creational_patterns.factory_pattern.model.Food;
import com.design_mode.creational_patterns.factory_pattern.model.Milk;

/**
 * @author: XueYing.Cao
 * @date: 2019/6/20
 * @description: 简单工厂
 */
public class SimpleFactory {
    public static final String CHOCOLATE = "chocolate";
    public static final String MILK = "milk";

    public Food createFood(String foodName) {
        switch (foodName) {
            case CHOCOLATE:
                return new Chocolate();
            case MILK:
                return new Milk();
            default:
                return null;
        }
    }
}
