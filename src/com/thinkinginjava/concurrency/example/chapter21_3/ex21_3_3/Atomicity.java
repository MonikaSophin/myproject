package com.thinkinginjava.concurrency.example.chapter21_3.ex21_3_3;

/**
 * @author: XueYing.Cao
 * @date: 2019/4/28
 * @description:
 */
public class Atomicity {
    int i;
    void f1() { i++; }
    void f2() { i+=3; }
}
