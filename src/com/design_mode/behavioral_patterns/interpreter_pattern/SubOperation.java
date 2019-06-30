package com.design_mode.behavioral_patterns.interpreter_pattern;

/**
 * @Author: monika
 * @Date: 2019/6/30 21:52
 * @Version: 1.0
 * @Description:
 * 步骤4.
 * 减法表达式实现类
 */
public class SubOperation extends NonTerminalExpression {

    public SubOperation(Expression e1, Expression e2) {
        super(e1, e2);
    }

    @Override
    public int interpret(Context context) {
        return e1.interpret(context) - e2.interpret(context);
    }
}
