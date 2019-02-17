package com.thinkinginjava.generics.example.chapter15_12.ex15_12_2;

import com.thinkinginjava.generics.example.chapter15_12.ex15_12_1.BasicHolder;

/**
 * @Author: monika
 * @Date: 2019/2/17 20:26
 * @Version: 1.0
 * @Description:
 */
class Other {}
class BasicOther extends BasicHolder<Other> {}

public class Unconstrained {
    public static void main(String[] args) {
        BasicOther b = new BasicOther();
        BasicOther b2 = new BasicOther();
        b.set(new Other());
        Other other = b.get();
        b.f();
    }
}
/**output:
 * Other
 */