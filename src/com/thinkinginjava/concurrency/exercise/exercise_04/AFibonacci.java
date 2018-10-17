package com.thinkinginjava.concurrency.exercise.exercise_04;

public class AFibonacci implements Runnable{
    private int n=0;
    public  AFibonacci(int n){
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
