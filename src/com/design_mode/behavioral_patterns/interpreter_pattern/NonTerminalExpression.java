package com.design_mode.behavioral_patterns.interpreter_pattern;

/**
 * @Author: monika
 * @Date: 2019/6/30 21:50
 * @Version: 1.0
 * @Description:
 * 步骤3.
 * 创建抽象的非终结符表达式
 */
public abstract class NonTerminalExpression implements Expression {
    Expression e1, e2;

    public NonTerminalExpression(Expression e1, Expression e2) {
        this.e1 = e1;
        this.e2 = e2;
    }
}
