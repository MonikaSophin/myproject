package com.thinkinginjava.concurrency.example.chapter21_2.ex21_2_14;

import java.util.concurrent.ThreadFactory;

public class HandlerThreadFactory implements ThreadFactory {
    @Override
    public Thread newThread(Runnable r) {
        System.out.println("HandlerThreadFactory creating new Thread");
        Thread t = new Thread(r);
        System.out.println("created "+t.getName());
        t.setUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
        System.out.println("eh = "+t.getUncaughtExceptionHandler());
        return t;
    }
}
