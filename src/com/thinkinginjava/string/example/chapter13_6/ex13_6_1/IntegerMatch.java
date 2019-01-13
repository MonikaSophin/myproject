package com.thinkinginjava.string.example.chapter13_6.ex13_6_1;

/**
 * @Author: monika
 * @Date: 2019/1/12 13:08
 * @Version: 1.0
 * @Description:
 */
public class IntegerMatch {
    public static void main(String[] args) {
        System.out.println("-1234".matches("-?\\d+"));
        System.out.println("5678".matches("-?\\d+"));
        System.out.println("+911".matches("-?\\d+"));
        System.out.println("+911".matches("(-|\\+)?\\d+"));
    }
}
/**output:
 * true
 * true
 * false
 * true
 */