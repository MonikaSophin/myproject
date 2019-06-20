package com.design_mode.d_factory_pattern.factory_method;

import com.design_mode.d_factory_pattern.model.Food;

/**
 * @author: XueYing.Cao
 * @date: 2019/6/20
 * @description:
 */
public class Test {
    public static void main(String[] args) {
        //工厂方法
        FactoryMethod factoryMethod = new FactoryMethod();
        Food chocolate = factoryMethod.produceChocolate();
        Food milk = factoryMethod.produceMilk();
        System.out.println(chocolate.getName() + " " + milk.getName());

        //静态工厂方法
        Food chocolate1 = StaticFactoryMethod.produceChocolate();
        Food milk1 = StaticFactoryMethod.produceMilk();
        System.out.println(chocolate1.getName() + " " + milk1.getName());
    }
}
/**output:
 * chocolate milk
 * chocolate milk
 */