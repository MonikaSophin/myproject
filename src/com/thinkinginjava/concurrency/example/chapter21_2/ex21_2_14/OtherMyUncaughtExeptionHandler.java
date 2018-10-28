package com.thinkinginjava.concurrency.example.chapter21_2.ex21_2_14;

public class OtherMyUncaughtExeptionHandler implements Thread.UncaughtExceptionHandler{
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("capture this exception "+e);
    }
}
