package com.thinkinginjava.operators.example.chapter3_15.ex3_15_1;

import com.thinkinginjava.util.Print;

/**
 * @Author: monika
 * @Date: 2018/11/4 17:54
 * @Version: 1.0
 * @Description: 将float或double转型为整型值时，总是对该数字执行截尾，
 * 如果相要得到舍入的结果，就需要使用java.lang.Math中的round()方法。
 */
public class CastingNumbers {
    public static void main(String[] args) {
        double above = 0.7, below = 0.4;
        float fabove = 0.7f, fbelow = 0.4f;
        Print.print("(int)above: " + (int) above);
        Print.print("(int)below: " + (int) below);
        Print.print("(int)fabove: " + (int) fabove);
        Print.print("(int)fbelow: " + (int) fbelow);
    }
}
/**
 * 输出：
 * (int)above: 0
 * (int)below: 0
 * (int)fabove: 0
 * (int)fbelow: 0
 */
