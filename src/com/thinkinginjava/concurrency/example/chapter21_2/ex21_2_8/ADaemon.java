package com.thinkinginjava.concurrency.example.chapter21_2.ex21_2_8;

import java.util.concurrent.TimeUnit;

public class ADaemon implements Runnable {
    @Override
    public void run() {
        try {
            while(true){//这里可以改为for()（有限个数的任务）,进行测试
                System.out.println("ADaemon start");
                System.out.println("ADaemon.isDaemon = " + Thread.currentThread().isDaemon());
                TimeUnit.SECONDS.sleep(1);//该线程休眠1s
            }
        } catch (InterruptedException e) {
            System.out.println("Exiting via InterruptedException");
        } finally {
            System.out.println(Thread.currentThread().isDaemon()+"  This should always run?");
        }
    }
}
