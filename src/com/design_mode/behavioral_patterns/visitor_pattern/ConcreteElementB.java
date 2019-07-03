package com.design_mode.behavioral_patterns.visitor_pattern;

/**
 * @author: XueYing.Cao
 * @date: 2019/7/3
 * @description:
 * 步骤2.
 * 实现数据元素接口， 将自身作为Visitor接口的方法形参。
 */
public class ConcreteElementB implements Element {

    @Override
    public void accpt(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public void doSomething() {
    System.out.println("ConcreteElementB doSomething!");
    }
}
