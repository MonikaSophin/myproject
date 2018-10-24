package com.thinkinginjava.concurrency.exercise.chapter21_2.exercise_08;

import java.util.concurrent.TimeUnit;

/**
 * page 655
 */
public class MoreBasicThreads implements Runnable{
    @Override
    public void run() {
        try{
            for (int i = 0; i < 5; i++) {//这里可以改为while(true)测试
                System.out.println(Thread.currentThread()+".isDaemon() = "
                        + Thread.currentThread().isDaemon() + ".");
            }
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            System.out.println("InterruptedException");
        } finally {
            System.out.println(Thread.currentThread()+" finally-- "
                    +Thread.currentThread()+".isDaemon() = "
                    + Thread.currentThread().isDaemon() + ".");
        }
    }
}
/**
 * 输出：略
 */