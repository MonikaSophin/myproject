package com.thinkinginjava.concurrency.exercise.chapter21_2.exercise_10;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FibonacciB implements Callable<Integer> {
    private Integer n = 0;
    ExecutorService exec = Executors.newCachedThreadPool();
    private  int fb(int x) {
        if(x < 2) return 1;
        return fb(x - 2) + fb(x - 1);
    }
    @Override
    public Integer call() throws Exception {
        int result = 0;
        System.out.println(Thread.currentThread().getName() + " >>start");
        for(int i = 1; i <= n; i++)
            result += fb(i);
        return (Integer)result;
    }
    public Future<Integer> runTask(Integer n) {
        this.n = n;
        //从始至终只有自身一个Callable
        return exec.submit(this);
    }
}
