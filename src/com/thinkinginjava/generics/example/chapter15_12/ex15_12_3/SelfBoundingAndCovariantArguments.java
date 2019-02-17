package com.thinkinginjava.generics.example.chapter15_12.ex15_12_3;

/**
 * @Author: monika
 * @Date: 2019/2/17 21:04
 * @Version: 1.0
 * @Description:
 */
interface SelfBoundSetter<T extends SelfBoundSetter<T>> {
    void set(T arg);
}

interface Setter extends SelfBoundSetter<Setter> {}

public class SelfBoundingAndCovariantArguments {
    void test(Setter s1, Setter s2, SelfBoundSetter sbs) {
        s1.set(s2);
        /**
         * 编译错误： SelfBoundSetter<Setter>中的set（Setter）
         * 无法应用于（SelfBoundSetter）
         */
        //! s1.set(sbs);
    }
}
