package com.thinkinginjava.containers.example.chapter17_9;

import java.util.Random;

/**
 * @author: XueYing.Cao
 * @date: 2019/2/26
 * @description:
 */
public class Prediction {
    private static Random rand = new Random(47);
    private boolean shadow = rand.nextDouble() > 0.5;
    @Override
    public String toString() {
        if (shadow)
            return "Six more weeks of winter";
        else
            return "Early Spring";
    }
}
