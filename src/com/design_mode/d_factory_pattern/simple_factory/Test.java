package com.design_mode.d_factory_pattern.simple_factory;

import com.design_mode.d_factory_pattern.model.Food;

/**
 * @author: XueYing.Cao
 * @date: 2019/6/20
 * @description:
 */
public class Test {
    public static void main(String[] args) {
        //简单工厂
        SimpleFactory factory = new SimpleFactory();
        Food food = factory.createFood(SimpleFactory.CHOCOLATE);
        System.out.println(food.getName());
    }
}
/**output:
 * chocolate
 */