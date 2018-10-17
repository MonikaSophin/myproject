package com.thinkinginjava.concurrency.exercise.exercise_03;

public class BRunnable implements Runnable {
    public BRunnable() {
        System.out.println(Thread.currentThread().getName() + " >> B init");
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " >> B start");
        for (int i = 0; i < 3; i++) {
            System.out.println(Thread.currentThread().getName() + " >> B running");
            Thread.yield();
        }
        System.out.println(Thread.currentThread().getName() + " >> B end");
        return;
    }
}
