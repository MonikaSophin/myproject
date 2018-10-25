package com.thinkinginjava.concurrency.exercise.chapter21_2.exercise_10;

import java.util.concurrent.*;

public class FibonacciA {
    public ExecutorService exec = Executors.newCachedThreadPool();
    private int n =0;
    private int fb(int x){
        if(x < 2) return 1;
        return fb(x-2) + fb(x-1);
    }
    public Future<Integer> runTask(int n){
        //一个Callable代表的就是一个驱动线程
        return exec.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                int count=0;
                System.out.println(Thread.currentThread().getName()+" >>start");
                for (int i=1;i<=n;i++)
                    count+=fb(i);
                return count;
            }
        });
    }


}
