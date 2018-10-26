package com.thinkinginjava.concurrency.exercise.chapter21_2.exercise_10;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @author: XueYing.Cao
 * @date: 2018/10/26
 * @description:
 */
public class Ex10_B {
    public static void main(String[] args) {
        FibonacciB fibb1 = new FibonacciB();
        try {
            for (int i = 1; i <= 10; i++)
                System.out.println(fibb1.runTask(i).get());
        } catch (InterruptedException e) {
            System.out.println("InterruptedException");
        } catch (ExecutionException e) {
            System.out.println("ExecutionException");
        } finally {
            fibb1.exec.shutdown();
        }

        System.out.println("-------------------------------");

        FibonacciB fibb2 = new FibonacciB();
        List<Future<Integer>> list = new ArrayList<>();
        for (int i = 1; i <= 10; i++)
            list.add(fibb2.runTask(i));

        try {
            for (Future<Integer> fs : list)
                System.out.println(fs.get());
        } catch (InterruptedException e) {
            System.out.println("InterruptedException");
        } catch (ExecutionException e) {
            System.out.println("ExecutionException");
        } finally {
            fibb2.exec.shutdown();
        }

    }
}
