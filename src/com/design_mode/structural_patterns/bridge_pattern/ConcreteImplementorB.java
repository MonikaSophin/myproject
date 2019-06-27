package com.design_mode.structural_patterns.bridge_pattern;

/**
 * @author: XueYing.Cao
 * @date: 2019/6/27
 * @description:
 */
public class ConcreteImplementorB implements Implementor {
    @Override
    public void operation() {
        System.out.println("ConcreteImplementorB operation()");
    }
}
