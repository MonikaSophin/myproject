package com.thinkinginjava.concurrency.example.chapter21_3.ex21_3_2;

import com.thinkinginjava.concurrency.example.chapter21_3.ex21_3_1.EvenChecker;
import com.thinkinginjava.concurrency.example.chapter21_3.ex21_3_1.IntGenerator;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: XueYing.Cao
 * @date: 2019/4/28
 * @description:
 */
public class MutexEvenGenerator extends IntGenerator {
    private int currentEvenValue = 0;
    private Lock lock = new ReentrantLock();
    @Override
    public int next() {
        lock.lock();
        try {
            ++currentEvenValue;
            Thread.yield(); // 导致失败更快
            ++currentEvenValue;
            return currentEvenValue;
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        EvenChecker.test(new MutexEvenGenerator());
    }
}
