package com.thinkinginjava.concurrency.example.chapter21_2.ex21_2_8;

import java.util.concurrent.TimeUnit;

public class Daemons {
    public static void main(String[] args) throws InterruptedException {
        //后台线程派生的子线程为后台线程。(这些子线程并没有显式地被设置为后台线程)
        Thread d = new Thread(new Daemon());
        d.setDaemon(true);
        d.start();
        System.out.println("d.isDaemon() = "+d.isDaemon()+".");
        TimeUnit.MILLISECONDS.sleep(1000);
    }
}
