package com.thinkinginjava.containers.example.chapter17_9;

/**
 * @author: XueYing.Cao
 * @date: 2019/2/26
 * @description:
 */
public class Groundhog {
    protected int number;
    public Groundhog(int number) { this.number = number; }
    @Override
    public String toString() { return String.format("Groundhog #%s", number); }
}
