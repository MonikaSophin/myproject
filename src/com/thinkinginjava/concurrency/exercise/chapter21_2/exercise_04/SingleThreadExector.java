package com.thinkinginjava.concurrency.exercise.chapter21_2.exercise_04;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleThreadExector {
    public static void main(String[] args){
        ExecutorService exec = Executors.newSingleThreadExecutor();
        for (int i=0;i<5;i++){
            exec.execute(new AFibonacci(6));
            exec.execute(new BFibonacci(6));
        }
        exec.shutdown();
    }
}
