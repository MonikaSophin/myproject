package com.thinkinginjava.concurrency.exercise.chapter21_2.exercise_08;

import java.util.concurrent.TimeUnit;

public class Ex08 {
    public static void main(String[] args)  {
        try {
            Thread thread = new Thread(new MoreBasicThreads());
            thread.setDaemon(true);
            thread.start();

            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            System.out.println("InterruptedException");
        } finally {
            System.out.println(Thread.currentThread()+" " +
                    "finally--");
        }
    }
}
/**
 * 结论：
 *   main线程完成任务之后会执行finally块语句。
 *   后台线程:
 *   如果后台线程 在程序结束之前 未完成自己的任务(被程序所终止)  则不会执行finally块语句。
 *   如果后台线程 在程序结束之前 完成了自己的任务(自己完成任务而终止)  则会执行到finally块语句。
 */