package com.thinkinginjava.concurrency.example.chapter21_3.ex21_3_4;

import com.thinkinginjava.concurrency.example.chapter21_3.ex21_3_1.EvenChecker;
import com.thinkinginjava.concurrency.example.chapter21_3.ex21_3_1.IntGenerator;
import com.thinkinginjava.concurrency.example.chapter21_3.ex21_3_2.MutexEvenGenerator;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: XueYing.Cao
 * @date: 2019/4/29
 * @description: 使用了 {@link AtomicInteger} 重写了 {@link MutexEvenGenerator}
 */
public class AtomicEvenGenerator extends IntGenerator {
    private AtomicInteger currentEvenValue = new AtomicInteger(0);
    @Override
    public int next() {
        return currentEvenValue.addAndGet(2);
    }

    public static void main(String[] args) {
        EvenChecker.test(new AtomicEvenGenerator());
    }
}
