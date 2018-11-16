package com.thinkinginjava.reusing_classes.example.chapter7_2;

/**
 * @Author: monika
 * @Date: 2018/11/14 21:21
 * @Version: 1.0
 * @Description:
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
        x.dilute(); x.apply(); x.scrub();
        System.out.println(x);
    }
}

public class Detergent extends Cleanser {
    // Change a method:
    public void scrub() {
        append(" Detergent.scrub()");
        super.scrub(); // Call base-class version
    }
    // Add methods to the interface:
    public void foam() { append(" foam()"); }

    // Test the new class:
    public static void main(String[] args) {
        Detergent x = new Detergent();
        x.dilute();
        x.apply();
        x.scrub();
        x.foam();
        System.out.println(x);
        System.out.println("Testing base class:");
        Cleanser.main(args);//将命令行参数传递给Cleanser的主函数，使其执行。
    }
}
/**输出：
 * Cleanser dilute() apply() Detergent.scrub() scrub() foam()
 * Testing base class:
 * Cleanser dilute() apply() scrub()
 */