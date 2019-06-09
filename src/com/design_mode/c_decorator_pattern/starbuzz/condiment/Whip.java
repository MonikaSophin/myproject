package com.design_mode.c_decorator_pattern.starbuzz.condiment;

import com.design_mode.c_decorator_pattern.starbuzz.beverage.Beverage;

/**
 * @Author: monika
 * @Date: 2019/6/9 16:17
 * @Version: 1.0
 * @Description:
 */
public class Whip extends CondimentDecorator {
    Beverage beverage;

    public Whip(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Whip";
    }

    @Override
    public double cost() {
        return 0.10 + beverage.cost();
    }
}
