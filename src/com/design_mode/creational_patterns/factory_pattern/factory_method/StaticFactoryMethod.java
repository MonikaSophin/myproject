package com.design_mode.creational_patterns.factory_pattern.factory_method;

import com.design_mode.creational_patterns.factory_pattern.model.Chocolate;
import com.design_mode.creational_patterns.factory_pattern.model.Food;
import com.design_mode.creational_patterns.factory_pattern.model.Milk;

/**
 * @author: XueYing.Cao
 * @date: 2019/6/20
 * @description: 静态工厂方法
 */
public class StaticFactoryMethod {

    public static Food produceChocolate() {
        return new Chocolate();
    }

    public static Food produceMilk() {
        return new Milk();
    }
}
