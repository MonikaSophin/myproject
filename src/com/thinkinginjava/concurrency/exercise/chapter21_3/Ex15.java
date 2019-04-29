package com.thinkinginjava.concurrency.exercise.chapter21_3;

import static com.thinkinginjava.util.Print.*;

/**
 * @author: XueYing.Cao
 * @date: 2019/4/29
 * @description: page 690
 * 练习15：创建一个类，它具有三个方法，这些方法包含一个临界区，所有对该临界区的
 * 同步但是在同一个对象上的。创建多个任务来演示这些方法同时只能运行一个。现在修
 * 改这些方法，使得每个方法都在不同的对象上同步，并展示所有三个方法可以同时运行。
 */
class SyncTest1 {
    public void f1() {
        synchronized (this) {
            for (int i = 1; i <= 3; i++) {
                print("f1(): " + i);
                Thread.yield();
            }
        }
    }
    public void g1() {
        synchronized (this) {
            for (int i = 1; i <= 3; i++) {
                print("g1(): " + i);
                Thread.yield();
            }
        }
    }
    public void h1() {
        synchronized (this) {
            for (int i = 1; i <= 3; i++) {
                print("h1(): " + i);
                Thread.yield();
            }
        }
    }
}

class SyncTest2 {
    private Object syncObject1 = new Object();
    private Object syncObject2 = new Object();
    private Object syncObject3 = new Object();
    public void f2() {
        synchronized (syncObject1) {
            for (int i = 1; i <= 3; i++) {
                print("f2(): " + i);
                Thread.yield();
            }
        }
    }
    public void g2() {
        synchronized (syncObject2) {
            for (int i = 1; i <= 3; i++) {
                print("g2(): " + i);
                Thread.yield();
            }
        }
    }
    public void h2() {
        synchronized (syncObject3) {
            for (int i = 1; i <= 3; i++) {
                print("h2(): " + i);
                Thread.yield();
            }
        }
    }
}

public class Ex15 {
    public static void main(String[] args) {
        SyncTest1 test1 = new SyncTest1();
        SyncTest2 test2 = new SyncTest2();
        new Thread(new Runnable() {
            @Override
            public void run() {
                test1.f1();
            }
        }).start();
        new Thread(() -> { test1.g1(); }).start();
        new Thread(() -> { test1.h1(); }).start();

        new Thread(() -> { test2.f2(); }).start();
        new Thread(() -> { test2.g2(); }).start();
        new Thread(() -> { test2.h2(); }).start();
    }
}
/**output(Sample):
 * f1(): 1
 * f1(): 2
 * f1(): 3
 * g1(): 1
 * g1(): 2
 * g1(): 3
 * h1(): 1
 * h1(): 2
 * h1(): 3
 *
 * f2(): 1
 * f2(): 2
 * f2(): 3
 * g2(): 1
 * g2(): 2
 * g2(): 3
 * h2(): 1
 * h2(): 2
 * h2(): 3
 */