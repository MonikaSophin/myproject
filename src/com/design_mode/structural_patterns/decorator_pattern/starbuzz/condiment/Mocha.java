package com.design_mode.structural_patterns.decorator_pattern.starbuzz.condiment;

import com.design_mode.structural_patterns.decorator_pattern.starbuzz.beverage.Beverage;

/**
 * @Author: monika
 * @Date: 2019/6/9 16:09
 * @Version: 1.0
 * @Description: 调料类 -- 摩卡
 */
public class Mocha extends CondimentDecorator {
    Beverage beverage;

    public Mocha(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Mocha";
    }

    @Override
    public double cost() {
        return 0.2 + beverage.cost();
    }
}
