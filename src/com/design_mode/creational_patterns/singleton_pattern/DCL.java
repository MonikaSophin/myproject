package com.design_mode.creational_patterns.singleton_pattern;

/**
 * @author: XueYing.Cao
 * @date: 2019/6/21
 * @description: 4.双检锁/双重检验锁(double-checked locking)
 */
public class DCL {
    private DCL() {}

    private volatile static DCL instance;

    public static DCL getInstance() {
        if (instance == null) {
            synchronized (DCL.class) {
                if (instance == null) {
                    instance = new DCL();
                }
            }
        }
        return instance;
    }
}
