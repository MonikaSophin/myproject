package com.thinkinginjava.concurrency.exercise.exercise_04;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedThreadPool {
    public static void main(String[] args){
        ExecutorService exec = Executors.newFixedThreadPool(5);
        for (int i=0;i<5;i++){
            exec.execute(new AFibonacci(6));
            exec.execute(new BFibonacci(6));
        }
        exec.shutdown();
    }
}
