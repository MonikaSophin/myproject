package com.thinkinginjava.concurrency.exercise_02;

/**
 * page 656
 *  练习2 遵循generic/Fibonacci.java的形式（在Thinking in Java的示例代码中），
 *  创建一个任务，它可以产生由n个斐波那契数字组成的序列，其中n是通过任务的构造器而提供的。
 *  使用线程创建大量的这种任务并驱动它们。
 */
class FibonacciA implements Runnable{
    private int n=0;
    public  FibonacciA(int n){
       System.out.println(Thread.currentThread().getName()+">> A init");
       this.n=n;
    }
    private int fb(int n){
        if(n < 2) return 1;
        return fb(n-2) + fb(n-1);
    }
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+">> start");
        for (int i=1;i<=n;i++){
            System.out.println(Thread.currentThread().getName()+"-----> "+fb(i));
        }
        System.out.println(Thread.currentThread().getName()+">> end");
    }
}
class FibonacciB implements Runnable{
    private int n=0;
    public  FibonacciB(int n){
        System.out.println(Thread.currentThread().getName()+">> B init");
        this.n=n;
    }
    private int fb(int n){
        if(n < 2) return 1;
        return fb(n-2) + fb(n-1);
    }
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+">> start");
        for (int i=1;i<=n;i++){
            System.out.println(Thread.currentThread().getName()+"-----> "+fb(i));
        }
        System.out.println(Thread.currentThread().getName()+">> end");
    }
}

public class Ex02 {
    public static void main(String[] args){
        new Thread(new FibonacciA(10),"thread_01").start();
        new Thread(new FibonacciA(10),"thread_02").start();
        new Thread(new FibonacciA(10),"thread_03").start();

        new Thread(new FibonacciB(10),"thread_04").start();
        new Thread(new FibonacciB(10),"thread_05").start();
        new Thread(new FibonacciB(10),"thread_06").start();
    }
}
