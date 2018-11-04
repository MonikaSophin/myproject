package com.thinkinginjava.controlling_execution.example.chapter4_3;

/**
 * @Author: monika
 * @Date: 2018/11/4 19:24
 * @Version: 1.0
 * @Description:
 */
public class WhileTest {
    static boolean condition() {
        boolean result = Math.random() < 0.99;
        System.out.print(result + ", ");
        return result;
    }

    public static void main(String[] args) {
        while (condition())
            System.out.println("Inside 'while'");
        System.out.println("Exited 'while'");
    }
}
/**
 * 当Math.random() >= 0.99时退出。
 */