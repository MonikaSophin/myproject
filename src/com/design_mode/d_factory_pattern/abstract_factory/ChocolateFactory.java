package com.design_mode.d_factory_pattern.abstract_factory;

import com.design_mode.d_factory_pattern.model.Chocolate;
import com.design_mode.d_factory_pattern.model.Food;

/**
 * @author: XueYing.Cao
 * @date: 2019/6/20
 * @description:
 */
public class ChocolateFactory implements AbstractFactory {
    @Override
    public Food produce() {
        return new Chocolate();
    }
}
