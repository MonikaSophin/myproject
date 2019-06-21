package com.design_mode.structural_patterns.decorator_pattern.starbuzz;

import com.design_mode.structural_patterns.decorator_pattern.starbuzz.beverage.Beverage;
import com.design_mode.structural_patterns.decorator_pattern.starbuzz.beverage.Espresso;
import com.design_mode.structural_patterns.decorator_pattern.starbuzz.beverage.HouseBlend;
import com.design_mode.structural_patterns.decorator_pattern.starbuzz.condiment.Mocha;
import com.design_mode.structural_patterns.decorator_pattern.starbuzz.condiment.Soy;
import com.design_mode.structural_patterns.decorator_pattern.starbuzz.condiment.Whip;

/**
 * @Author: monika
 * @Date: 2019/6/9 16:12
 * @Version: 1.0
 * @Description: 测试类
 */
public class StarbuzzCoffee {

    public static void main(String[] args) {
        //订一杯Espresso,不加调料
        Beverage beverage = new Espresso();
        System.out.println(beverage.getDescription()
                + " $" + beverage.cost());

        //定一杯HouseBlend,加豆浆、摩卡、奶泡
        Beverage beverage2 = new HouseBlend();
        beverage2 = new Soy(beverage2);
        beverage2 = new Mocha(beverage2);
        beverage2 = new Whip(beverage2);
        System.out.println(beverage2.getDescription()
                + " $" + beverage2.cost());
    }
}
/**output:
 * Espresso $1.99
 * House Blend Coffee, Soy, Mocha, Whip $1.34
 */