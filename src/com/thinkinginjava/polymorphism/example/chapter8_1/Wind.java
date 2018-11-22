package com.thinkinginjava.polymorphism.example.chapter8_1;

/**
 * @Author: monika
 * @Date: 2018/11/19 20:56
 * @Version: 1.0
 * @Description:
 */
public class Wind extends Instrument {
    // Redefine interface method:
    public void play(Note n) {
        System.out.println("Wind.play() " + n);
    }
}