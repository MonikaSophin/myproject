package com.design_mode.behavioral_patterns.visitor_pattern;

/**
 * @author: XueYing.Cao
 * @date: 2019/7/3
 * @description:
 * 步骤3.
 * 创建访问者接口
 */
public interface Visitor {

    void visit(ConcreteElementA element);

    void visit(ConcreteElementB element);
}
