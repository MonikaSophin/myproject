package com.design_mode.creational_patterns.singleton_pattern;

/**
 * @author: XueYing.Cao
 * @date: 2019/6/21
 * @description: 1.懒汉式，线程不安全的。
 */
public class Lazy_ThreadUnsafe {
    private Lazy_ThreadUnsafe() {}

    private static Lazy_ThreadUnsafe instance;

    public static Lazy_ThreadUnsafe getInstance() {
        if (instance == null)
            instance = new Lazy_ThreadUnsafe();
        return instance;
    }
}
