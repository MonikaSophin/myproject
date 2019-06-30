package com.design_mode.behavioral_patterns.interpreter_pattern;

/**
 * @Author: monika
 * @Date: 2019/6/30 21:59
 * @Version: 1.0
 * @Description:
 * 步骤3.
 * 终结符表达式（在这个例子，用来存放数字，或者代表数字的字符）
 */
public class TerminalExpression implements Expression {

    private String variable;

    public TerminalExpression(String variable){
        this.variable = variable;
    }

    @Override
    public int interpret(Context context) {
        return context.cast(this);
    }
}
