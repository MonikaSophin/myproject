package com.thinkinginjava.concurrency.exercise.chapter21_2.exercise_10;

import java.util.concurrent.ExecutionException;

/**
 * @author: XueYing.Cao
 * @date: 2018/10/26
 * @description:
 */
public class Ex10_C {
    public static void main(String[] args) throws Exception{
        FibonacciC fibc = new FibonacciC();
        try {
            for(int i = 1; i <=10; i++)
                System.out.println(fibc.runTask(i));
        } catch(InterruptedException e) {
            System.out.println("InterruptedException");
        } catch(ExecutionException e) {
            System.out.println("ExecutionException");
        } finally {
            fibc.exec.shutdown();
        }

    }
}
