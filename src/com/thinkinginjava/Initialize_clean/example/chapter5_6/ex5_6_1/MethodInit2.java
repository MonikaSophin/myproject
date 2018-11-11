package com.thinkinginjava.Initialize_clean.example.chapter5_6.ex5_6_1;

/**
 * @Author: monika
 * @Date: 2018/11/11 15:26
 * @Version: 1.0
 * @Description:
 */
public class MethodInit2 {
    int i = f();
    int j = g(i);
    int f() { return 11; }
    int g(int n) { return n * 10; }
}
