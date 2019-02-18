package com.thinkinginjava.generics.example.chapter15_16;

/**
 * @author: XueYing.Cao
 * @date: 2019/2/18
 * @description:
 */
class CommunicateSimply {
    /**
     * 在本例中，泛型不是必需的，因为这些类已经被强制要求实现Performs接口，
     */
    static void perform (Performs performer) {
        performer.speak();
        performer.sit();
    }
}

public class SimpleDogsAndRobots {
    public static void main(String[] args) {
        CommunicateSimply.perform(new PerformingDog());
        CommunicateSimply.perform(new Robot());
    }
}
/**output:
 * Woof!
 * Sitting
 * Click!
 * Clank!
 */