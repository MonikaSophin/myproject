package com.design_mode.c_decorator_pattern.starbuzz.condiment;

import com.design_mode.c_decorator_pattern.starbuzz.beverage.Beverage;

/**
 * @Author: monika
 * @Date: 2019/6/9 16:15
 * @Version: 1.0
 * @Description: 调料类 -- 豆浆
 */
public class Soy extends CondimentDecorator {
    Beverage beverage;

    public Soy(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Soy";
    }

    @Override
    public double cost() {
        return 0.15 + beverage.cost();
    }
}
