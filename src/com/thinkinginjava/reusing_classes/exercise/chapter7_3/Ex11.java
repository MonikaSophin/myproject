package com.thinkinginjava.reusing_classes.exercise.chapter7_3;


import com.thinkinginjava.access_control.exercise.chapter6_2.Ex05;

/**
 * @Author: monika
 * @Date: 2018/11/15 22:00
 * @Version: 1.0
 * @Description: page 132
 * 练习11： 修改Detergent.java（page 128）,让它使用代理。
 */
class Cleanser {
    private String s = "Cleanser";
    public void append(String a) { s += a; }
    public void dilute() { append(" dilute()"); }
    public void apply() { append(" apply()"); }
    public void scrub() { append(" scrub()"); }
    public String toString() { return s; }
    public static void main(String[] args) {
        Cleanser x = new Cleanser();
        x.dilute();
        x.scrub();
        x.apply();
        System.out.println(x);
    }
}

public class Ex11 {
    private String s = "Ex11";
    private Cleanser c = new Cleanser();
    public void append(String a) { s += a; }
    // two methods delegated entirely to Cleanser c:
    public void dilute() { c.dilute(); }
    public void apply() { c.apply(); }
    // method delegated in part to Cleanser c:
    public void scrub() {
        append(" Ex11.scrub()");
        c.scrub();
    }
    public void foam() { append(" foam()"); }
    public String toString() { return s + "----" + c; }
    public static void main(String[] args) {
        Ex11 x = new Ex11();
        x.dilute();
        x.apply();
        x.scrub();
        x.foam();
        System.out.println(x);
        System.out.println("Testing base class:");
        Cleanser.main(args);
    }
}
/**输出：
 * Ex11 Ex11.scrub() foam()----Cleanser dilute() apply() scrub()
 * Testing base class:
 * Cleanser dilute() scrub() apply()
 */