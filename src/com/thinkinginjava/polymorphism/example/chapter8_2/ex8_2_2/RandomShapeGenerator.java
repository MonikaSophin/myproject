package com.thinkinginjava.polymorphism.example.chapter8_2.ex8_2_2;

import java.util.Random;

/**
 * @Author: monika
 * @Date: 2018/11/19 21:21
 * @Version: 1.0
 * @Description:
 */
public class RandomShapeGenerator {
    private Random rand = new Random(47);
    public Shape next() {
        switch(rand.nextInt(3)) {
            default:
            case 0: return new Circle();
            case 1: return new Square();
            case 2: return new Triangle();
        }
    }
}
