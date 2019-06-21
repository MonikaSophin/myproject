package com.design_mode.creational_patterns.builder_pattern;

/**
 * @author: XueYing.Cao
 * @date: 2019/6/21
 * @description:
 * 建造者类
 */
public abstract class Builder {
    protected Computer computer = new Computer();
    public abstract void buildBrand();
    public abstract void buildCPU();
    public abstract void buildMainBoard();
    public abstract void buildHardDisk();
    public abstract void buildDisplayCard();
    public abstract void buildPower();
    public abstract void buildMemory();
    public Computer createComputer() {
        return computer;
    }
}
