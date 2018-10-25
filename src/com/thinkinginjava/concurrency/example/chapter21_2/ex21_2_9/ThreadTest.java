package com.thinkinginjava.concurrency.example.chapter21_2.ex21_2_9;

public class ThreadTest {
    public static  void main(String[] args){
        new InnerThread1("InnerThread1");
        new InnerThread2("InnerThread2");
        new InnerRunnable1("InnerRunnable1");
        new InnerRunnable2("InnerRunnable2");
        new ThreadMethod("ThreadMethod").runTask();
    }
}
