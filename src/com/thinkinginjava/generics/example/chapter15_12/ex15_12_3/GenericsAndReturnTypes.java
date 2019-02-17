package com.thinkinginjava.generics.example.chapter15_12.ex15_12_3;

/**
 * @Author: monika
 * @Date: 2019/2/17 20:54
 * @Version: 1.0
 * @Description:
 */
interface GenericGetter<T extends GenericGetter<T>> {
    T get();
}

interface Getter extends GenericGetter<Getter> {}

public class GenericsAndReturnTypes {
    void test(Getter getter) {
        Getter g = getter.get();
        // 取到的也是基类 类型
        GenericGetter gg = getter.get();
    }
}
