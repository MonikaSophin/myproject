package com.thinkinginjava.holding_objects.example.chapter11_8;

/**
 * @Author: monika
 * @Date: 2018/12/16 11:17
 * @Version: 1.0
 * @Description:
 */
public class StackTest {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        for(String s : "My dog has fleas".split(" ")){
            stack.push(s);
        }
        System.out.println(stack);

        while(!stack.empty())
            System.out.print(stack.pop() + " ");
        System.out.println();
        System.out.println(stack);
    }
}
/**输出：
 * [fleas, has, dog, My]
 * fleas has dog My
 * []
 */