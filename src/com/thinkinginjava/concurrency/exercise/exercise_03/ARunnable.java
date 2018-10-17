package com.thinkinginjava.concurrency.exercise.exercise_03;

public class ARunnable implements Runnable {
    public ARunnable() {
        System.out.println(Thread.currentThread().getName() + " >> A init");
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " >> A start");
        for (int i = 0; i < 3; i++) {
            System.out.println(Thread.currentThread().getName() + " >> A running");
            Thread.yield();
        }
        System.out.println(Thread.currentThread().getName() + " >> A end");
        return;
    }
}
