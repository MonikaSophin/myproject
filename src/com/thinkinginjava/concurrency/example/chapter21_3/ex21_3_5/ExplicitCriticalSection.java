package com.thinkinginjava.concurrency.example.chapter21_3.ex21_3_5;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: XueYing.Cao
 * @date: 2019/4/29
 * @description: 使用显式的Lock对象来创建临界区
 */
//同步整个方法
class ExplicitPairManager1 extends PairManager {
    private Lock lock = new ReentrantLock();
    @Override
    public synchronized void increment() {
        lock.lock();
        try {
            p.incrementX();
            p.incrementY();
            store(getPair());
        } finally {
            lock.unlock();
        }
    }
}

//同步关键部分("临界区")
class ExplicitPairManager2 extends PairManager {
    private Lock lock = new ReentrantLock();
    @Override
    public void increment() {
        Pair temp;
        lock.lock();
        try {
           // synchronized (this) {
                p.incrementX();
                p.incrementY();
                temp = getPair();
          //  }
        } finally {
            lock.unlock();
        }
        store(temp);
    }
}

public class ExplicitCriticalSection {
    public static void main(String[] args) {
        PairManager
                pman1 = new ExplicitPairManager1(),
                pman2 = new ExplicitPairManager2();
        CriticalSection.testApproaches(pman1, pman2);
    }
}
/**output(Sample):
 * pm1: Pair: x: 13, y: 13 checkCounter = 52957
 * pm2: Pair: x: 14, y: 14 checkCounter = 1902771
 */