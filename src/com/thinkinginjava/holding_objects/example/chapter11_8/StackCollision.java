package com.thinkinginjava.holding_objects.example.chapter11_8;

/**
 * @Author: monika
 * @Date: 2018/12/16 11:22
 * @Version: 1.0
 * @Description:
 */
public class StackCollision {
    public static void main(String[] args) {
        com.thinkinginjava.holding_objects.example.chapter11_8.Stack<String> stack =
                new com.thinkinginjava.holding_objects.example.chapter11_8.Stack();
        for(String s : "My dog has fleas".split(" "))
            stack.push(s);
        while(!stack.empty())
            System.out.print(stack.pop() + " ");
        System.out.println();

        java.util.Stack<String> stack2 =
                new java.util.Stack();
        for(String s : "My dog has fleas".split(" "))
            stack2.push(s);
        while(!stack2.empty())
            System.out.print(stack2.pop() + " ");
    }
}
/**输出：
 * fleas has dog My
 * fleas has dog My
 */
