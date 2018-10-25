package com.thinkinginjava.concurrency.example.chapter21_2.ex21_2_9;

/**
 * inheriting directly from the the Thread class
 * 直接从Thread类继承
 */
public class SimpleThread extends Thread {//Thread实现了Runnable接口
    private int countDown = 5;
    public SimpleThread() {
        //给线程起名
        this.start();
    }
    @Override
    public String toString() {
        return "#" + getName() +"  ("+countDown+"),";
    }
    @Override
    public void run() {
        while (true){
            System.out.println(this);
            if (--countDown == 0)
                return;
        }
    }
    public static void main(String[] args){
        for (int i = 0; i < 5; i++) {
            new SimpleThread();
        }
    }
}
