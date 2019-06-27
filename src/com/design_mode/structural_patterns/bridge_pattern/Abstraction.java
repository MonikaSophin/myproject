package com.design_mode.structural_patterns.bridge_pattern;

/**
 * @author: XueYing.Cao
 * @date: 2019/6/27
 * @description:
 * 3.桥接者
 * 定义抽象类的接口，它维护了一个指向Implementor类型对象的指针。
 */
public abstract class Abstraction {
    private Implementor implementor;

    public Abstraction(Implementor implementor) {
        this.implementor = implementor;
    }

    public Implementor getImplementor() {
        return implementor;
    }

    protected abstract void handle();
}
