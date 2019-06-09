package com.design_mode.c_decorator_pattern.starbuzz.beverage;

/**
 * @Author: monika
 * @Date: 2019/6/9 16:00
 * @Version: 1.0
 * @Description: 饮料类
 */
public abstract class Beverage {
    String description = "Unknown Beverage";

    public String getDescription() {
        return description;
    }

    public abstract double cost();
}
