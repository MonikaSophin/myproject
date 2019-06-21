package com.design_mode.e_singleton_pattern;

/**
 * @author: XueYing.Cao
 * @date: 2019/6/21
 * @description:
 */
public class StaticInnerClass {
    private StaticInnerClass() {}

    private static class InstanceHolder {
        private static final StaticInnerClass INSTANCE = new StaticInnerClass();
    }

    public static final StaticInnerClass getInstance() {
        return InstanceHolder.INSTANCE;
    }
}
