package com.thinkinginjava.generics.exercise.chapter15_15.color;

import java.util.Random;

/**
 * @author: XueYing.Cao
 * @date: 2019/2/18
 * @description:
 */
public class ColoredImp implements Colored{
    private String[] colors = {"red", "yellow", "green", "black", "blue"};
    private Random random = new Random(47);
    @Override
    public String getColor() { return colors[random.nextInt(colors.length)]; }
}