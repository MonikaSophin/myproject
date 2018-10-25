package com.thinkinginjava.concurrency.example.chapter21_2.ex21_2_9;

import java.util.concurrent.TimeUnit;

/**
 * Using a named Runnable implementation
 * 使用内部类实现Runnable并创建驱动线程。
 */
public class InnerRunnable1 {
    public InnerRunnable1(String name) {
        inner = new Inner(name);
    }

    private int countDown =5;
    private Inner inner;
    private class Inner implements Runnable{
        Thread t;
        public Inner(String name) {
            t = new Thread(this,name);
            t.start();
        }
        @Override
        public void run() {
            try {
                while (true) {
                    System.out.println(this);
                    if (--countDown == 0) return;
                    TimeUnit.MILLISECONDS.sleep(10);
                }
            } catch (InterruptedException e) {
                System.out.println("InterruptedException");
            }
        }

        @Override
        public String toString() {
            return t.getName()+": "+countDown;
        }
    }
}
