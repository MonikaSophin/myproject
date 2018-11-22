package com.thinkinginjava.polymorphism.exercise.chapter8_2;

import com.thinkinginjava.polymorphism.example.chapter8_1.Note;

/**
 * @Author: monika
 * @Date: 2018/11/20 21:39
 * @Version: 1.0
 * @Description: page 155
 * 练习07：向Music3.java添加一个新的类型Instrument,并验证多态性是否作用于所添加
 * 的新类型。
 */
class NewInstrument extends Instrument{
    @Override
    void play(Note n) { System.out.println("NewInstrument.play() " + n);}
    @Override
    public String toString() { return "NewInstrument"; }
    @Override
    void adjust() { System.out.println("Adjusting NewInstrument"); }
}

public class Ex07 {
    public static void main(String[] args) {
        Instrument[] orchestra = {
                new Wind(),
                new Percussion(),
                new Stringed(),
                new Brass(),
                new Woodwind(),
                new NewInstrument()
        };
        Music6.tuneAll(orchestra);
        for (Instrument i: orchestra) {
            System.out.println(i);
        }
    }
}
/**输出：
 * Wind.play() MIDDLE_C
 * Percussion.play() MIDDLE_C
 * Stringed.play() MIDDLE_C
 * Brass.play() MIDDLE_C
 * Woodwind.play() MIDDLE_C
 * NewInstrument.play() MIDDLE_C
 * Wind
 * Percussion
 * Stringed
 * Brass
 * Woodwind
 * NewInstrument
 */