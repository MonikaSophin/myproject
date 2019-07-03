package com.design_mode.behavioral_patterns.visitor_pattern;

/**
 * @author: XueYing.Cao
 * @date: 2019/7/3
 * @description:
 * 步骤4.
 * 实现Visitor的接口
 */
public class ConcreteVisitor implements Visitor {

    @Override
    public void visit(ConcreteElementA element) {
        element.doSomething();
    }

    @Override
    public void visit(ConcreteElementB element) {
        element.doSomething();
    }
}
