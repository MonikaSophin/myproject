package com.thinkinginjava.concurrency.exercise.chapter21_3;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static com.thinkinginjava.util.Print.print;

/**
 * @author: XueYing.Cao
 * @date: 2019/4/29
 * @description: page 690
 * 练习16：使用显式的Lock对象来修改练习15。
 */
class SyncTest3 {
    private Lock lock = new ReentrantLock();
    public void f1() {
        lock.lock();
        try {
            for (int i = 1; i <= 3; i++) {
                print("f1(): " + i);
                Thread.yield();
            }
        } finally {
           lock.unlock();
        }
    }
    public void g1() {
        lock.lock();
        try {
            for (int i = 1; i <= 3; i++) {
                print("g1(): " + i);
                Thread.yield();
            }
        } finally {
            lock.unlock();
        }
    }
    public void h1() {
        lock.lock();
        try {
            for (int i = 1; i <= 3; i++) {
                print("h1(): " + i);
                Thread.yield();
            }
        } finally {
            lock.unlock();
        }
    }
}

class SyncTest4 {
    private Lock lock1 = new ReentrantLock();
    private Lock lock2 = new ReentrantLock();
    private Lock lock3 = new ReentrantLock();
    public void f2() {
        lock1.lock();
        try {
            for (int i = 1; i <= 3; i++) {
                print("f2(): " + i);
                Thread.yield();
            }
        } finally {
            lock1.unlock();
        }
    }
    public void g2() {
        lock2.lock();
        try {
            for (int i = 1; i <= 3; i++) {
                print("g2(): " + i);
                Thread.yield();
            }
        } finally {
            lock2.unlock();
        }
    }
    public void h2() {
        lock3.lock();
        try {
            for (int i = 1; i <= 3; i++) {
                print("h2(): " + i);
                Thread.yield();
            }
        } finally {
            lock3.unlock();
        }
    }
}

public class Ex16 {
    public static void main(String[] args) {
        SyncTest3 test3 = new SyncTest3();
        SyncTest4 test4 = new SyncTest4();
        new Thread(() -> { test3.f1(); }).start();
        new Thread(() -> { test3.g1(); }).start();
        new Thread(() -> { test3.h1(); }).start();

        new Thread(() -> { test4.f2(); }).start();
        new Thread(() -> { test4.g2(); }).start();
        new Thread(() -> { test4.h2(); }).start();
    }
}
/**output(Sample):
 * g1(): 1
 * g1(): 2
 * g1(): 3
 * f1(): 1
 * f1(): 2
 * f1(): 3
 * h1(): 1
 * h1(): 2
 * h1(): 3
 *
 * h2(): 1
 * g2(): 1
 * f2(): 1
 * h2(): 2
 * g2(): 2
 * h2(): 3
 * f2(): 2
 * g2(): 3
 * f2(): 3
 */
