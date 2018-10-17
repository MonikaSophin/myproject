package com.thinkinginjava.concurrency.exercise.exercise_03;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CachedThradPool {
    public static void main(String[] args){
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i=0;i<5;i++){
            exec.execute(new ARunnable());
            exec.execute(new BRunnable());
        }
        exec.shutdown();
    }
}
