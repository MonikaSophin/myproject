package com.design_mode.structural_patterns.bridge_pattern;

/**
 * @author: XueYing.Cao
 * @date: 2019/6/27
 * @description:
 */
public class Test {
    public static void main(String[] args) {
        Abstraction abstraction1 = new RefinedAbstraction(new ConcreteImplementorA());
        Abstraction abstraction2 = new RefinedAbstraction(new ConcreteImplementorB());

        abstraction1.handle();
        abstraction2.handle();
    }
}
