package com.thinkinginjava.concurrency.example.chapter21_2.ex21_2_9;

/**
 * Using an anonymous inner class.
 * 在构造函数中使用匿名内部类创建线程并驱动它。
 */
public class InnerThread2 {
    private int countDown = 5;
    private Thread t;
    public InnerThread2(String name) {
        t = new Thread(name) {
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
                return getName() + ": " + countDown;
            }
        };

        t.start();
    }
}
