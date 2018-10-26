package com.thinkinginjava.concurrency.exercise.chapter21_2.exercise_10;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class Ex10_A {
    public static void main(String[] args){
        List<Future<Integer>> results = new ArrayList<>();
        FibonacciA fiba= new FibonacciA();

        for (int i=1;i<=10;i++){
            results.add(fiba.runTask(i));
        }
        for (Future<Integer> fs:results) {
            try {
                System.out.println(fs.get());
            } catch (InterruptedException e) {
                System.out.println("InterruptedException");
            } catch (ExecutionException e) {
                System.out.println("ExecutionException");
            }finally {
                fiba.exec.shutdown();
            }
        }


    }
}
