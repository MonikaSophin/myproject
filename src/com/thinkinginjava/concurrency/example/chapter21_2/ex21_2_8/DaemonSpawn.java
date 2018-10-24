package com.thinkinginjava.concurrency.example.chapter21_2.ex21_2_8;

public class DaemonSpawn implements  Runnable {
    @Override
    public void run() {
        while (true)
            Thread.yield();
    }
}
