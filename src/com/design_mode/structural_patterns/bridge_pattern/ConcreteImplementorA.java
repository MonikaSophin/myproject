package com.design_mode.structural_patterns.bridge_pattern;

/**
 * @author: XueYing.Cao
 * @date: 2019/6/27
 * @description:
 * 2.实现Implementor接口并定义它的具体实现。
 */
public class ConcreteImplementorA implements Implementor {
    @Override
    public void operation() {
        System.out.println("ConcreteImplementorA operation()");
    }
}
