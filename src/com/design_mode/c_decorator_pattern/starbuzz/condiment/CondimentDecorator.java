package com.design_mode.c_decorator_pattern.starbuzz.condiment;

import com.design_mode.c_decorator_pattern.starbuzz.beverage.Beverage;

/**
 * @Author: monika
 * @Date: 2019/6/9 16:02
 * @Version: 1.0
 * @Description: 调料类/装饰者抽象类
 */
public abstract class CondimentDecorator extends Beverage {
    @Override
    public abstract String getDescription();
}
