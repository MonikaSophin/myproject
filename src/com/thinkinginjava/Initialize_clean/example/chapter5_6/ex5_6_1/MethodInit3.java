package com.thinkinginjava.Initialize_clean.example.chapter5_6.ex5_6_1;

/**
 * @Author: monika
 * @Date: 2018/11/11 15:27
 * @Version: 1.0
 * @Description:
 */
public class MethodInit3 {
    //! int j = g(i); // Illegal forward reference
    int i = f();
    int f() { return 11; }
    int g(int n) { return n * 10; }
}
