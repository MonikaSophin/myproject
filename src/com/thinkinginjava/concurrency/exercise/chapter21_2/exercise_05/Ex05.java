package com.thinkinginjava.concurrency.exercise.chapter21_2.exercise_05;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Ex05 {
    public static void main(String[] args){
        ExecutorService exec = Executors.newCachedThreadPool();
        List<Future<Integer>> resultsA = new ArrayList<>();
        List<Future<Integer>> resultsB = new ArrayList<>();
        for (int i=1;i<=10;i++){
            resultsA.add(exec.submit(new FibonacciA(i)));
            resultsB.add(exec.submit(new FibonacciB(i)));
        }
        for (Future<Integer> fs:resultsA) {
            try {
                System.out.println(fs.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }finally {
                exec.shutdown();
            }
        }
        for (Future<Integer> fs:resultsB) {
            try {
                System.out.println(fs.get());
            } catch (InterruptedException e) {
                System.out.println(e);
            } catch (ExecutionException e) {
                System.out.println(e);
            }finally {
                exec.shutdown();
            }
        }
    }
}
