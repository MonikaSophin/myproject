package com.thinkinginjava.concurrency.exercise.chapter21_2.exercise_03;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleThreadExector {
    public static void main(String[] args){
        ExecutorService exec = Executors.newSingleThreadExecutor();
        for (int i=0;i<5;i++){
            exec.execute(new ARunnable());
            exec.execute(new BRunnable());
        }
        exec.shutdown();
    }
}
