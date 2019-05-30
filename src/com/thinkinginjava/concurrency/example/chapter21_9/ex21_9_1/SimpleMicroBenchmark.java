package com.thinkinginjava.concurrency.example.chapter21_9.ex21_9_1;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: XueYing.Cao
 * @date: 2019/5/29
 * @description:
 */
abstract class Incrementable {
    protected long counter = 0;
    public abstract void increment();
}

class SynchronizingTest extends Incrementable {
    @Override
    public synchronized void increment() { ++counter; }
}

class LockingTest extends Incrementable {
    private Lock lock = new ReentrantLock();
    @Override
    public void increment() {
        lock.lock();
        try {
            ++counter;
        } finally {
            lock.unlock();
        }
    }
}

public class SimpleMicroBenchmark {
    static long test(Incrementable incrementable) {
        long start = System.nanoTime();
        for (int i = 0; i < 10000000L; i++)
            incrementable.increment();
        return System.nanoTime() - start;
    }

    public static void main(String[] args) {
        long synchTime = test(new SynchronizingTest());
        long lockTime = test(new LockingTest());
        System.out.printf("synchronized: %1$10d\n", synchTime);
        System.out.printf("Lock: %1$10d\n", lockTime);
        System.out.printf("Lock/synchronized = %1$.3f\n", (double) lockTime/(double) synchTime);
    }
}
/**output(Sample):
 * synchronized:  228771841
 * Lock:  183849449
 * Lock/synchronized = 0.804
 */