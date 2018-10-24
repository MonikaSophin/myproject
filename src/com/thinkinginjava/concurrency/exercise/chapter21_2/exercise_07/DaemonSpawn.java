package com.thinkinginjava.concurrency.exercise.chapter21_2.exercise_07;

public class DaemonSpawn implements  Runnable {
    @Override
    public void run() {
        while (true)
            Thread.yield();
    }
}
