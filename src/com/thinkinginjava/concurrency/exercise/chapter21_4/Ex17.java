package com.thinkinginjava.concurrency.exercise.chapter21_4;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import static com.thinkinginjava.util.Print.*;

/**
 * @author: XueYing.Cao
 * @date: 2019/4/30
 * @description: page 694
 * 练习17：创建一个辐射计数器，它可以具有任意数量的传感器。
 */
class RadCount {
    private int count = 0;
    private Random rand = new Random();
    public synchronized int increment() {
        return ++count;
    }
    public synchronized int value() { return count; }
}

//传感器
class Sensor implements Runnable {
    private static RadCount count = new RadCount();
    private static List<Sensor> sensors = new ArrayList<Sensor>();
    private int number = 0;
    // Doesn't need synchronization to read:
    private final int id;
    private static volatile boolean canceled = false;
    // Atomic operation on a volatile field:
    public static void cancel() { canceled = true; }
    public Sensor(int id) {
        this.id = id;
        // Keep this task in a list. Also prevents
        // garbage collection of dead tasks:
        sensors.add(this);
    }
    public void run() {
        while(!canceled) {
            synchronized(this) {
                ++number;
            }
            print(this + " Total: " + count.increment());
            try {
                TimeUnit.MILLISECONDS.sleep(50);
            } catch(InterruptedException e) {
                print("sleep interrupted");
            }
        }
        print("Stopping " + this);
    }
    public synchronized int getValue() { return number; }
    public String toString() {
        return "Sensor " + id + ": " + getValue();
    }
    public static int getTotalCount() {
        return count.value();
    }
    public static int sumSensors() {
        int sum = 0;
        for(Sensor sensor : sensors)
            sum += sensor.getValue();
        return sum;
    }
}

public class Ex17 {
    public static void main(String[] args) throws Exception {
        ExecutorService exec = Executors.newCachedThreadPool();
        for(int i = 1; i <= 3; i++)
            exec.execute(new Sensor(i));
        // Run for a while, then stop and collect the data:
        TimeUnit.SECONDS.sleep(3);
        Sensor.cancel();
        exec.shutdown();

        if(!exec.awaitTermination(250, TimeUnit.MILLISECONDS))
            print("Some tasks were not terminated");
        print("Total: " + Sensor.getTotalCount());
        print("Sum of Sensors: " + Sensor.sumSensors());
    }
}
/**output(Sample):
 * Sensor 2: 1 Total: 2
 * Sensor 3: 1 Total: 3
 * Sensor 1: 1 Total: 1
 * Sensor 2: 2 Total: 4
 * Sensor 3: 2 Total: 5
 * ...
 * Sensor 3: 48 Total: 144
 * Sensor 2: 48 Total: 143
 * Sensor 2: 49 Total: 146
 * Sensor 1: 49 Total: 145
 * Sensor 3: 49 Total: 147
 * Stopping Sensor 1: 49
 * Stopping Sensor 3: 49
 * Stopping Sensor 2: 49
 * Total: 147
 * Sum of Sensors: 147
 */