package com.design_mode.creational_patterns.builder_pattern;

/**
 * @author: XueYing.Cao
 * @date: 2019/6/21
 * @description:
 * 指挥装配类
 */
public class Director {
    public Computer builder(Builder builder) {
        builder.buildBrand();
        builder.buildCPU();
        builder.buildDisplayCard();
        builder.buildHardDisk();
        builder.buildMainBoard();
        builder.buildMemory();
        builder.buildPower();
        Computer computer = builder.createComputer();
        return computer;
    }
}
