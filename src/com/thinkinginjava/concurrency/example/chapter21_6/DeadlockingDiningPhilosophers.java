package com.thinkinginjava.concurrency.example.chapter21_6;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author: XueYing.Cao
 * @date: 2019/5/17
 * @description:
 */
public class DeadlockingDiningPhilosophers {
    public static void main(String[] args) throws InterruptedException {
        int ponder = 5;
        int size = 5;
        ExecutorService exec = Executors.newCachedThreadPool();
        Chopstick[] sticks = new Chopstick[size];
        for (int i = 0; i < size; i++)
            sticks[i] = new Chopstick();

        for (int i = 0; i < size; i++)
            exec.execute(new Philosopher(sticks[i], sticks[(i + 1) % size], i, ponder));
        TimeUnit.SECONDS.sleep(5);
        exec.shutdownNow();
    }
}
/**output（Sample）:
 * Philosopher 1 thinking
 * Philosopher 2 thinking
 * Philosopher 0 thinking
 * Philosopher 3 thinking
 * Philosopher 4 thinking
 * Philosopher 1 grabbing right
 * Philosopher 1 grabbing left
 * Philosopher 1 eating
 * Philosopher 2 grabbing right
 * Philosopher 2 grabbing left
 * Philosopher 4 grabbing right
 * Philosopher 4 grabbing left
 * Philosopher 4 eating
 * Philosopher 0 grabbing right
 * Philosopher 3 grabbing right
 * Philosopher 1 thinking
 * Philosopher 4 thinking
 * Philosopher 3 grabbing left
 * Philosopher 0 grabbing left
 * Philosopher 0 eating
 * Philosopher 2 eating
 * Philosopher 4 grabbing right
 * Philosopher 1 grabbing right
 * Philosopher 0 thinking
 * Philosopher 1 grabbing left
 * Philosopher 1 eating
 * Philosopher 2 thinking
 * Philosopher 4 grabbing left
 * Philosopher 3 eating
 * Philosopher 0 grabbing right
 * Philosopher 2 grabbing right
 * Philosopher 3 thinking
 * Philosopher 4 eating
 * Philosopher 2 grabbing left
 * Philosopher 1 thinking
 * Philosopher 0 grabbing left
 * Philosopher 2 eating
 * Philosopher 3 grabbing right
 * Philosopher 4 thinking
 * Philosopher 3 grabbing left
 * Philosopher 0 eating
 * Philosopher 2 thinking
 * Philosopher 3 eating
 * Philosopher 1 grabbing right
 * Philosopher 1 grabbing left
 * Philosopher 0 thinking
 * Philosopher 1 eating
 * Philosopher 3 thinking
 * Philosopher 4 grabbing right
 * Philosopher 4 grabbing left
 * Philosopher 4 eating
 * Philosopher 2 grabbing right
 * Philosopher 2 grabbing left
 * Philosopher 1 thinking
 * Philosopher 2 eating
 * Philosopher 4 thinking
 * Philosopher 2 thinking
 * Philosopher 0 grabbing right
 * Philosopher 0 grabbing left
 * Philosopher 0 eating
 * Philosopher 3 grabbing right
 * Philosopher 3 grabbing left
 * Philosopher 3 eating
 * Philosopher 0 thinking
 * Philosopher 3 thinking
 * Philosopher 1 grabbing right
 * Philosopher 1 grabbing left
 * Philosopher 1 eating
 * Philosopher 4 exiting via interrupt
 * Philosopher 0 exiting via interrupt
 * Philosopher 1 exiting via interrupt
 * Philosopher 2 exiting via interrupt
 * Philosopher 3 exiting via interrupt
 */