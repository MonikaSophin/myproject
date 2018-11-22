package com.thinkinginjava.polymorphism.exercise.chapter8_3;

/**
 * @Author: monika
 * @Date: 2018/11/21 21:41
 * @Version: 1.0
 * @Description: page 159
 * 练习11：向Sandwich.java中添加Pickle类。
 */
class Meal {
    Meal() { System.out.println("Meal()"); }
}

class Bread {
    Bread() { System.out.println("Bread()"); }
}

class Cheese {
    Cheese() { System.out.println("Cheese()"); }
}

class Lettuce {
    Lettuce() { System.out.println("Lettuce()"); }
}

class Pickle {
    Pickle() { System.out.println("Pickle()"); }
}

class Lunch extends Meal {
    Lunch() { System.out.println("Lunch()"); }
}

class PortableLunch extends Lunch {
    PortableLunch() { System.out.println("PortableLunch()"); }
}

class Sandwich11 extends PortableLunch {
    private Bread b = new Bread();
    private Cheese c = new Cheese();
    private Pickle p = new Pickle();
    private Lunch l = new Lunch();
    public Sandwich11() { System.out.println("Sandwich()"); }

}

public class Ex11 {
    public static void main(String[] args) {
        new Sandwich11();
    }
}
/**输出：
 * Meal()
 * Lunch()
 * PortableLunch()
 * Bread()
 * Cheese()
 * Pickle()
 * Meal()
 * Lunch()
 * Sandwich()
 */