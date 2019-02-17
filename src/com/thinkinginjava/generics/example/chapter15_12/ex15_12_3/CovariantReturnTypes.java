package com.thinkinginjava.generics.example.chapter15_12.ex15_12_3;

/**
 * @Author: monika
 * @Date: 2019/2/17 20:48
 * @Version: 1.0
 * @Description:
 */
class Base {}
class Derived extends Base {}

interface OrdinaryGetter {
    Base get();
}

interface DerivedGetter extends OrdinaryGetter {
    // 覆写方法的返回类型 可以是协变的。
    @Override
    Derived get();
}

public class CovariantReturnTypes {
    void test(DerivedGetter d) {
        Derived derived = d.get();
    }
}
