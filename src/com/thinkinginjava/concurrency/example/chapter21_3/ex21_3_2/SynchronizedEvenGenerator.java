package com.thinkinginjava.concurrency.example.chapter21_3.ex21_3_2;

import com.thinkinginjava.concurrency.example.chapter21_3.ex21_3_1.EvenChecker;
import com.thinkinginjava.concurrency.example.chapter21_3.ex21_3_1.IntGenerator;

/**
 * @author: XueYing.Cao
 * @date: 2019/4/28
 * @description:
 */
public class SynchronizedEvenGenerator extends IntGenerator {
    private int currentEvenValue = 0;
    @Override
    public synchronized int next() {
        ++currentEvenValue;
        Thread.yield();
        ++currentEvenValue;
        return currentEvenValue;
    }

    public static void main(String[] args) {
        EvenChecker.test(new SynchronizedEvenGenerator());
    }
}
