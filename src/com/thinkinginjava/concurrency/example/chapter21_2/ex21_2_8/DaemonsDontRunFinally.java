package com.thinkinginjava.concurrency.example.chapter21_2.ex21_2_8;

import java.util.concurrent.TimeUnit;

public class DaemonsDontRunFinally {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new ADaemon());
        t.setDaemon(true);
        t.start();

        TimeUnit.SECONDS.sleep(3);//main线程休眠3s
    }
}
/**输出:
 * ADaemon start
 * ADaemon.isDaemon = true
 * ADaemon start
 * ADaemon.isDaemon = true
 * ADaemon start
 * ADaemon.isDaemon = true
 *  结论：
 *    后台线程不会执行到finally块语句
 */
