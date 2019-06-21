package com.design_mode.e_singleton_pattern;

/**
 * @author: XueYing.Cao
 * @date: 2019/6/21
 * @description: 3.饿汉式
 */
public class Hungry {
    private Hungry() {}

    private static Hungry instance = new Hungry();

    public static Hungry getInstance() {
        return instance;
    }
}
