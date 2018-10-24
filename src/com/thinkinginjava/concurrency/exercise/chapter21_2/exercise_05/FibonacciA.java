package com.thinkinginjava.concurrency.exercise.chapter21_2.exercise_05;

import java.util.concurrent.Callable;

public class FibonacciA implements Callable {
    private int n=0;
    private int count=0;//总和
    public  FibonacciA(int n){
        System.out.println(Thread.currentThread().getName()+">> A init");
        this.n=n;
    }
    private int fb(int n){
        if(n < 2) return 1;
        return fb(n-2) + fb(n-1);
    }
    @Override
    public Integer call() throws Exception {
        System.out.println(Thread.currentThread().getName()+">> A start");
        for (int i=1;i<=n;i++){
            count+=fb(i);
        }
        System.out.println(Thread.currentThread().getName()+">> A end");
        return count;
    }
}
