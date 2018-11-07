package com.thinkinginjava.Initialize_clean.example.chapter5_1;

/**
 * @Author: monika
 * @Date: 2018/11/7 22:03
 * @Version: 1.0
 * @Description:
 */
class Rock {
    public Rock() {
        System.out.println("Rock");
    }
}

public class SimpleConstructor {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Rock();
        }
    }
}
/**输出：
 * Rock
 * Rock
 * Rock
 * Rock
 * Rock
 * Rock
 * Rock
 * Rock
 * Rock
 * Rock
 */