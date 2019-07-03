package com.design_mode.behavioral_patterns.visitor_pattern;

/**
 * @author: XueYing.Cao
 * @date: 2019/7/3
 * @description:
 * 步骤1.
 * 创建数据结构的接口
 */
public interface Element {

    void accpt(Visitor visitor);

    void doSomething();
}
