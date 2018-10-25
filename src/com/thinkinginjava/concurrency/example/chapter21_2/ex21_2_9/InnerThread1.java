package com.thinkinginjava.concurrency.example.chapter21_2.ex21_2_9;

import java.util.concurrent.TimeUnit;

/**
 * Creating threads with inner classes.
 * 使用内部类继承线程并驱动它。并从构造中创建线程。
 */
public class InnerThread1 {
    public InnerThread1(String name) {
        inner = new Inner(name);
    }
    private int countDown = 5;
    private Inner inner;
    private class Inner extends Thread {
        Inner(String name) {
            super(name);
            this.start();
        }
        @Override
        public void run() {
            try {
                while (true) {
                    System.out.println(this);
                    if (--countDown == 0) return;
                    sleep(10);
                }
            } catch (InterruptedException e) {
                System.out.println("InterruptedException");
            }
        }

        @Override
        public String toString() {
            return getName()+": "+countDown;
        }
    }

}
