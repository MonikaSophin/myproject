package com.thinkinginjava.polymorphism.example.chapter8_1;

/**
 * @Author: monika
 * @Date: 2018/11/19 20:56
 * @Version: 1.0
 * @Description:
 */
public class Music {
    public static void tune(Instrument i) {
        // ...
        i.play(Note.MIDDLE_C);
    }
    public static void main(String[] args) {
        Wind flute = new Wind();
        tune(flute); // Upcasting
    }
}
/**输出：
 * Wind.play() MIDDLE_C
 */