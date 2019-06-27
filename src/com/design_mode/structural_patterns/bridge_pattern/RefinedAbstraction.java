package com.design_mode.structural_patterns.bridge_pattern;

/**
 * @author: XueYing.Cao
 * @date: 2019/6/27
 * @description:\
 * 4.扩充由Abstraction定义的接口
 */
public class RefinedAbstraction extends Abstraction {

    public RefinedAbstraction(Implementor implementor) {
        super(implementor);
    }

    @Override
    protected void handle() {
        super.getImplementor().operation();
    }
}
