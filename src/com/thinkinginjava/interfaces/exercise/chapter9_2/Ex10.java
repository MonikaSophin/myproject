package com.thinkinginjava.interfaces.exercise.chapter9_2;

/**
 * @Author: monika
 * @Date: 2018/11/25 10:35
 * @Version: 1.0
 * @Description: page 174
 * 练习10：修改Music5.java，添加Playable接口。将play()的声明从Instrument中移到
 * Playable中。通过将Playable包括在implements列表中，把Playable添加到导出类中。
 * 修改tune()，使它接受Playable而不是Instrument作为参数。
 */
interface Instrument10 {
    // Compile-time constant:
    int VALUE = 5; // static and final
    // Cannot have method definitions:
    void adjust();
}

interface Playable {
    void play(Note n); // Automatically public
}

class Wind10 implements Instrument10, Playable {
    public void play(Note n) { System.out.println(this + ".play() " + n); }
    public String toString() { return "Wind10"; }
    public void adjust() { System.out.println(this + ".adjust()"); }
}


class Percussion10 implements Instrument10, Playable {
    public void play(Note n) { System.out.println(this + ".play() " + n); }
    public String toString() { return "Percussion10"; }
    public void adjust() { System.out.println(this + ".adjust()"); }
}

class Stringed10 implements Instrument10, Playable {
    public void play(Note n) { System.out.println(this + ".play() " + n); }
    public String toString() { return "Stringed10"; }
    public void adjust() { System.out.println(this + ".adjust()"); }
}

class Brass10 extends Wind10 {
    public String toString() { return "Brass10"; }
}

class Woodwind10 extends Wind10 {
    public String toString() { return "Woodwing10"; }
}

class Music10 {
    // Doesn't care about type, so new types
    // added to the system will work right:
    static void tune(Playable p) {
        //...
        p.play(Note.MIDDLE_C);
    }
    static void tuneAll(Playable[] e) {
        for(Playable p : e)
            tune(p);
    }

}

public class Ex10 {
    public static void main(String[] args) {
        // Upcasting during addition to the array:
        Playable[] orchestra = {
                new Wind10(),
                new Percussion10(),
                new Stringed10(),
                new Brass10(),
                new Woodwind10()
        };
        Music10.tuneAll(orchestra);
    }
}
/**输出：
 * Wind10.play() MIDDLE_C
 * Percussion10.play() MIDDLE_C
 * Stringed10.play() MIDDLE_C
 * Brass10.play() MIDDLE_C
 * Woodwing10.play() MIDDLE_C
 */