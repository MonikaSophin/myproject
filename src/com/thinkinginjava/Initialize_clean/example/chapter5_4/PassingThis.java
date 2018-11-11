package com.thinkinginjava.Initialize_clean.example.chapter5_4;

/**
 * @Author: monika
 * @Date: 2018/11/10 21:11
 * @Version: 1.0
 * @Description:
 */
class Person {
    public void eat(Apple apple) {
        Apple peeled = apple.getPeeled();
        System.out.println("Yummy");
    }
}

class Peeler {
    static Apple peel(Apple apple) {
        // ... remove peel
        return apple; // Peeled
    }
}

class Apple {
    Apple getPeeled() { return Peeler.peel(this); }
}

public class PassingThis {
    public static void main(String[] args) {
        new Person().eat(new Apple());
    }
}
/**输出：
 * Yummy
 */
