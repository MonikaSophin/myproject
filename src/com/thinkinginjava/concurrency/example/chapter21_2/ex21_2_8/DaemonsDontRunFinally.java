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
 *     main线程完成任务之后会执行finally块语句。
 *     后台线程:
 *     如果后台线程 在程序结束之前 未完成自己的任务(被程序所终止)  则不会执行finally块语句。
 *  *  如果后台线程 在程序结束之前 完成了自己的任务(自己完成任务而终止)  则会执行到finally块语句。
 */
