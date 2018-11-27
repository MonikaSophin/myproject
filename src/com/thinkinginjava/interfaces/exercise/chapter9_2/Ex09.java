package com.thinkinginjava.interfaces.exercise.chapter9_2;

/**
 * @Author: monika
 * @Date: 2018/11/25 10:33
 * @Version: 1.0
 * @Description: page 174
 * 练习09：重构Music5.java，将在Wind、Percussion和Stringed中的
 * 公共方法移入一个抽象类中。
 */
enum Note {
    MIDDLE_C, C_SHARP, B_FLAT; // Etc.
}

abstract class Instrument {
    private int i;
    public abstract void play(Note n);
    public String toString() { return "Instrument"; }
    public abstract void adjust();
}

class Wind extends Instrument {
    public void play(Note n) { System.out.println(this + ".play() " + n); }
    public String toString() { return "Wind"; }
    public void adjust() { System.out.println(this + ".adjust()"); }
}

class Percussion extends Instrument {
    public void play(Note n) { System.out.println(this + ".play() " + n); }
    public String toString() { return "Percussion"; }
    public void adjust() { System.out.println(this + ".adjust()"); }
}

class Stringed extends Instrument {
    public void play(Note n) { System.out.println(this + ".play() " + n); }
    public String toString() { return "Stringed"; }
    public void adjust() { System.out.println(this + ".adjust()"); }
}

class Brass extends Wind {
    public String toString() { return "Brass"; }
}

class Woodwind extends Wind {
    public String toString() { return "Woodwing"; }
}

class Music9 {
    // Doesn't care about type, so new types
    // added to the system will work right:
    static void tune(Instrument i) {
        //...
        i.play(Note.MIDDLE_C);
    }

    static void tuneAll(Instrument[] e) {
        for (Instrument i : e)
            tune(i);
    }
}

public class Ex09 {
    public static void main(String[] args) {
        // Upcasting during addition to the array:
        Instrument[] orchestra = {
                new Wind(),
                new Percussion(),
                new Stringed(),
                new Brass(),
                new Woodwind()
        };
        Music9.tuneAll(orchestra);
    }
}
/**输出：
 * Wind.play() MIDDLE_C
 * Percussion.play() MIDDLE_C
 * Stringed.play() MIDDLE_C
 * Brass.play() MIDDLE_C
 * Woodwing.play() MIDDLE_C
 */
