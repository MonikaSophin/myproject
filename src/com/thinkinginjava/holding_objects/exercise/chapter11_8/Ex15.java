package com.thinkinginjava.holding_objects.exercise.chapter11_8;

import com.thinkinginjava.util.Stack;

/**
 * @Author: monika
 * @Date: 2018/12/16 11:24
 * @Version: 1.0
 * @Description: page 231
 * 练习15：栈在编程语言中经常用来对表达式求值。请使用本章示例中的Stack类对下面的
 * 表达式求值，其中“+”表示将“将后面的字母压进栈”，而“-”表示“弹出栈顶字母并打印它”：
 *  “+U+u+c---+e+r+t---+a-+i-+n+t+y---+-+r+u--+l+e+s---”
 */
public class Ex15 {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        stack.push("U");
        stack.push("u");
        stack.push("c");
        System.out.print(stack.pop());
        System.out.print(stack.pop());
        System.out.print(stack.pop());
        stack.push("e");
        stack.push("r");
        stack.push("t");
        System.out.print(stack.pop());
        System.out.print(stack.pop());
        System.out.print(stack.pop());
        stack.push("a");
        System.out.println(stack.pop());
        stack.push("i");
        System.out.print(stack.pop());
        stack.push("n");
        stack.push("t");
        stack.push("y");
        System.out.print(stack.pop());
        System.out.print(stack.pop());
        System.out.print(stack.pop());
        stack.push("");
        System.out.print(stack.pop());
        stack.push("r");
        stack.push("u");
        System.out.print(stack.pop());
        System.out.print(stack.pop());
        stack.push("l");
        stack.push("e");
        stack.push("s");
        System.out.print(stack.pop());
        System.out.print(stack.pop());
        System.out.print(stack.pop());
    }
}
/**输出：
 * cuUtrea
 * iytnursel
 */