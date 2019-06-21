package com.design_mode.structural_patterns.decorator_pattern.starbuzz.beverage;

/**
 * @Author: monika
 * @Date: 2019/6/9 16:06
 * @Version: 1.0
 * @Description: 饮料类 -- 混合咖啡
 */
public class HouseBlend extends Beverage {
    public HouseBlend() {
        description = "House Blend Coffee";
    }
    @Override
    public double cost() {
        return 0.89;
    }
}
