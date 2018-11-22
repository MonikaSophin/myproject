package com.thinkinginjava.polymorphism.exercise.chapter8_2;

import com.thinkinginjava.polymorphism.example.chapter8_1.Music;
import com.thinkinginjava.polymorphism.example.chapter8_2.ex8_2_3.Music3;

import java.util.Random;

/**
 * @Author: monika
 * @Date: 2018/11/20 21:45
 * @Version: 1.0
 * @Description: page 155
 * 练习08：修改Music3.java，使其可以像Shapes.java中的方式那样随机创建Instrument对象。
 */
class Music8{
    private Random rand = new Random(47);
    public Instrument next() {
        switch(rand.nextInt(5)) {
            default:
            case 0: return new Wind();
            case 1: return new Percussion();
            case 2: return new Stringed();
            case 3: return new Brass();
            case 4: return new Woodwind();
        }
    }
}
public class Ex08 {
    public static void main(String[] args) {
        Music8 music8 = new Music8();
        Instrument[] instruments = new Instrument[10];
        for (int i = 0; i <instruments.length ; i++) {
            instruments[i] = music8.next();
        }

        Music6.tuneAll(instruments);
    }
}
/**输出：
 * Brass.play() MIDDLE_C
 * Wind.play() MIDDLE_C
 * Brass.play() MIDDLE_C
 * Percussion.play() MIDDLE_C
 * Percussion.play() MIDDLE_C
 * Woodwind.play() MIDDLE_C
 * Brass.play() MIDDLE_C
 * Wind.play() MIDDLE_C
 * Stringed.play() MIDDLE_C
 * Stringed.play() MIDDLE_C
 */