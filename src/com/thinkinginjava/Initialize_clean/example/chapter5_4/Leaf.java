package com.thinkinginjava.Initialize_clean.example.chapter5_4;

/**
 * @Author: monika
 * @Date: 2018/11/10 21:10
 * @Version: 1.0
 * @Description:
 */
public class Leaf {
    int i = 0;
    Leaf increment() {
        i++;
        return this;
    }
    void print() {
        System.out.println("i = " + i);
    }
    public static void main(String[] args) {
        Leaf x = new Leaf();
        x.increment().increment().increment().print();
    }
}
/**输出：
 * i = 3
 */
