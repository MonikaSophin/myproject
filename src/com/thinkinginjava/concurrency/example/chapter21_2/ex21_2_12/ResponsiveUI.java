package com.thinkinginjava.concurrency.example.chapter21_2.ex21_2_12;

public class ResponsiveUI extends Thread {
    private static volatile double d = 1;
    public ResponsiveUI() {
        setDaemon(true);
        start();
    }
    @Override
    public void run() {
        while (true) {
            d = d + 1;
           // System.out.println(d);
        }
    }

    public static void main(String[] args) throws Exception {
        //new UnResponsiveUI();
        new ResponsiveUI();
        /**
         * 等待用户输入，主线程处于阻塞状态。
         * 本后台线程会一直在运行，直至用户输入之后，main线程结束,本后台进程被结束。
         */
        System.in.read();
        System.out.println(d);
    }
}

