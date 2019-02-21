package com.thinkinginjava.generics.example.chapter15_16;

import com.thinkinginjava.util.pets.Dog;

/**
 * @author: XueYing.Cao
 * @date: 2019/2/18
 * @description:
 */
class PerformingDog extends Dog implements Performs {
    @Override
    public void speak() { System.out.println("Woof!"); }
    @Override
    public void sit() { System.out.println("Sitting"); }
    public void reproduce() {}
}

class Communicate {
    /**
     * perform()不需要使用泛型来工作，它可以被简单的指定为接受一个Performs对象。
     * {@link CommunicateSimply#perform(Performs)}
     */
    public static <T extends Performs> void perform(T performer) {
        performer.speak();
        performer.sit();
    }
}

public class DogsAndRobots {
    public static void main(String[] args) {
        PerformingDog d = new PerformingDog();
        Robot r = new Robot();
        Communicate.perform(d);
        Communicate.perform(r);
    }
}
/**output:
 * Woof!
 * Sitting
 * Click!
 * Clank!
 */