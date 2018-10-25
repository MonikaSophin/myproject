package com.thinkinginjava.concurrency.example.chapter21_2.ex21_2_9;

import java.util.concurrent.TimeUnit;

/**
 * Using an anonymous Runnable implementation
 * 使用匿名内部类去实现Runnable接口并驱动线程
 */
public class InnerRunnable2 {
    private int countDown = 5;
    private Thread t;

    public InnerRunnable2(String name) {
        t = new Thread(new Runnable() {
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
                return Thread.currentThread().getName()+": "+countDown;
            }
        },name);

        t.start();
    }
}
