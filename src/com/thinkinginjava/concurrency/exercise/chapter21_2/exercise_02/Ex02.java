package com.thinkinginjava.concurrency.exercise.chapter21_2.exercise_02;

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
        System.out.println(Thread.currentThread().getName()+">> A start");
        for (int i=1;i<=n;i++){
            System.out.println(Thread.currentThread().getName()+"-----> "+fb(i));
        }
        System.out.println(Thread.currentThread().getName()+">> A end");
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
        System.out.println(Thread.currentThread().getName()+">> B start");
        for (int i=1;i<=n;i++){
            System.out.println(Thread.currentThread().getName()+"-----> "+fb(i));
        }
        System.out.println(Thread.currentThread().getName()+">> B end");
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
