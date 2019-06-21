package com.design_mode.creational_patterns.singleton_pattern;

/**
 * @author: XueYing.Cao
 * @date: 2019/6/21
 * @description: 2.懒汉式，线程安全的
 */
public class Lazy_ThreadSafe {
    private Lazy_ThreadSafe() {}

    private static Lazy_ThreadSafe instance;

    public static synchronized Lazy_ThreadSafe getInstance() {
        if (instance == null)
            instance = new Lazy_ThreadSafe();
        return instance;
    }
}
