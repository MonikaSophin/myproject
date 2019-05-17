package com.thinkinginjava.concurrency.example.chapter21_6;

/**
 * @author: XueYing.Cao
 * @date: 2019/5/17
 * @description:
 */
public class Chopstick {
    private boolean taken = false;
    public synchronized void take() throws InterruptedException {
        while (taken)
            wait();
        taken = true;
    }
    public synchronized void drop() {
        taken = false;
        notifyAll();
    }
}
