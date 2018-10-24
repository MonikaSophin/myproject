package com.thinkinginjava.concurrency.example.chapter21_2.ex21_2_8;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class DamonFromFactory implements Runnable{
    @Override
    public void run() {
        try {
            while(true){
            TimeUnit.MILLISECONDS.sleep(100);
            System.out.println(Thread.currentThread() + " " + this);
            }
        } catch (InterruptedException e) {
            System.out.println("interrupted");
        }
    }
    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool(new DaemonThreadFactory());
        for (int i = 0; i <10 ; i++) {
            exec.execute(new DamonFromFactory());
        }
        System.out.println("All daemons started");
        //控制main线程(非后台线程)的睡眠时间(延迟main方法结束时间)。
        // 一旦main线程终止，所有后台线程会“突然”终止。
        TimeUnit.MILLISECONDS.sleep(1000);
    }
}
