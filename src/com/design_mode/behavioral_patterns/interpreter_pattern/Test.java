package com.design_mode.behavioral_patterns.interpreter_pattern;

/**
 * @Author: monika
 * @Date: 2019/6/30 22:01
 * @Version: 1.0
 * @Description:
 *
 */
public class Test {
    public static void main(String[] args) {
        Context context = new Context();
        Expression a = new TerminalExpression("a");
        Expression b = new TerminalExpression("b");
        Expression c = new TerminalExpression("c");
        context.add(a, 4);
        context.add(b, 8);
        context.add(c, 2);

        Expression add = new AddOperation(a, b);
        System.out.println("a + b = " + add.interpret(context));
        Expression sub = new SubOperation(add, c);
        System.out.println("a + b - c = " + sub.interpret(context));
    }
}
/**output:
 * a + b = 12
 * a + b - c = 10
 */