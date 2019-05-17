package com.thinkinginjava.concurrency.example.chapter21_5.ex21_5_3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static com.thinkinginjava.util.Print.*;

/**
 * @author: XueYing.Cao
 * @date: 2019/5/9
 * @description:
 */
class Meal {
    private final int orderNum;
    public Meal(int orderNum) { this.orderNum = orderNum; }
    @Override
    public String toString() { return "Meal " + orderNum; }
}

class WaitPerson implements Runnable {
    private Restaurant restaurant;
    public WaitPerson(Restaurant restaurant) { this.restaurant = restaurant; }
    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                synchronized (this) {
                    while (restaurant.meal == null)
                        wait();
                }
                print("Waitperson got " + restaurant.meal);
                synchronized (restaurant.chef) {
                    restaurant.meal = null;
                    restaurant.chef.notifyAll(); //让厨师准备下一个
                }
            }
        } catch (InterruptedException e) {
            print("WaitPerson interrupted");
        }
    }
}

class Chef implements Runnable {
    private Restaurant restaurant;
    private int count = 0;
    public Chef(Restaurant restaurant) { this.restaurant = restaurant; }
    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                synchronized (this) {
                    while (restaurant.meal != null)
                        wait();
                }
                if (++count == 10) {
                    print("Out of food, closing");
                    restaurant.exec.shutdownNow();
                }
                printnb("Order up! ");
                synchronized (restaurant.waitPerson) {
                    restaurant.meal = new Meal(count);
                    restaurant.waitPerson.notifyAll();
                }
                TimeUnit.MILLISECONDS.sleep(100);
            }
        } catch (InterruptedException e) {
            print("Chef interrupted");
        }
    }
}

public class Restaurant {
    Meal meal;
    Chef chef = new Chef(this);
    WaitPerson waitPerson = new WaitPerson(this);
    ExecutorService exec = Executors.newCachedThreadPool();
    public Restaurant() {
        exec.execute(chef);
        exec.execute(waitPerson);
    }

    public static void main(String[] args) {
        new Restaurant();
    }
}
/**output:
 * Order up! Waitperson got Meal 1
 * Order up! Waitperson got Meal 2
 * Order up! Waitperson got Meal 3
 * Order up! Waitperson got Meal 4
 * Order up! Waitperson got Meal 5
 * Order up! Waitperson got Meal 6
 * Order up! Waitperson got Meal 7
 * Order up! Waitperson got Meal 8
 * Order up! Waitperson got Meal 9
 * Out of food, closing
 * Order up! WaitPerson interrupted
 * Chef interrupted
 */