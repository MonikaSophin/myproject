package com.design_mode.d_factory_pattern.factory_method;

import com.design_mode.d_factory_pattern.model.Chocolate;
import com.design_mode.d_factory_pattern.model.Food;
import com.design_mode.d_factory_pattern.model.Milk;

/**
 * @author: XueYing.Cao
 * @date: 2019/6/20
 * @description: 工厂方法
 */
public class FactoryMethod {

    public Food produceChocolate() {
        return new Chocolate();
    }

    public Food produceMilk() {
        return new Milk();
    }
}
