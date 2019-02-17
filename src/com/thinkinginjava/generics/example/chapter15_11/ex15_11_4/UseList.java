package com.thinkinginjava.generics.example.chapter15_11.ex15_11_4;

import java.util.List;

/**
 * @Author: monika
 * @Date: 2019/2/16 19:46
 * @Version: 1.0
 * @Description:
 */
public class UseList<W, T> {
    void f(List<T> v) {}
    /**
     * 由于泛型擦除的原因，重载方法将产生相同的类型签名
     */
    //! void f(List<W> v) {}
}

class UseList2<W, T> {
    /**
     *  与此不同的是，当被擦除的参数不能产生唯一的参数列表时，
     * 必须提供明显有区别的方法名。
     */
    void f1(List<T> v) {}
    void f2(List<W> v) {}
}
