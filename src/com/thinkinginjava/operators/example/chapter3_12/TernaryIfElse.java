package com.thinkinginjava.operators.example.chapter3_12;

import com.thinkinginjava.util.Print;

/**
 * @Author: monika
 * @Date: 2018/11/4 15:58
 * @Version: 1.0
 * @Description: ternary:三元
 */
public class TernaryIfElse {
    public static void main(String[] args) {
        Print.print(ternary(9));
        Print.print(ternary(10));
        Print.print(standardIfElse(9));
        Print.print(standardIfElse(10));
    }

    static int ternary(int i) {
        return i < 10 ? i * 100 : i * 10;
    }
    static int standardIfElse(int i) {
        if(i < 10)
            return i * 100;
        else
            return i * 10;
    }
}
/**输出：
 * 900
 * 100
 * 900
 * 100
 */
