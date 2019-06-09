package com.design_mode.c_decorator_pattern.starbuzz.beverage;

/**
 * @Author: monika
 * @Date: 2019/6/9 16:06
 * @Version: 1.0
 * @Description: 饮料类 -- 浓缩咖啡
 */
public class Espresso extends Beverage {
    public Espresso() {
        description = "Espresso";
    }

    @Override
    public double cost() {
        return 1.99;
    }
}
