package com.thinkinginjava.generics.example.chapter15_10.ex15_10_1;

import com.thinkinginjava.generics.example.chapter15_10.model.Apple;
import com.thinkinginjava.generics.example.chapter15_10.model.Fruit;
import com.thinkinginjava.generics.example.chapter15_10.model.Orange;

/**
 * @author: XueYing.Cao
 * @date: 2019/2/14
 * @description:
 */
public class Holder<T> {
    private T value;
    public Holder() {}
    public Holder(T value) { this.value = value; }
    public T getValue() { return value; }
    public void setValue(T value) { this.value = value; }
    @Override
    public boolean equals(Object obj) { return value.equals(obj); }

    public static void main(String[] args) {
        Holder<Apple> apple = new Holder<>(new Apple());
        Apple d = apple.getValue();
        apple.setValue(d);

        // 不能转型
        //! Holder<Fruit> fruit = apple;
        Holder<? extends Fruit> fruit = apple; //ok
        Fruit p = fruit.getValue();
        d = (Apple) fruit.getValue();
        try{
            Orange c = (Orange) fruit.getValue(); //无警告
        }catch (Exception e) {
            System.out.println(e);
        }
        //! fruit.setValue(new Apple());
        //! fruit.setValue(new Fruit());
        System.out.println(fruit.equals(d));
    }
}
/**output:
 * java.lang.ClassCastException: com.thinkinginjava.generics.example.chapter15_10.model.Apple cannot be cast to com.thinkinginjava.generics.example.chapter15_10.model.Orange
 * true
 */