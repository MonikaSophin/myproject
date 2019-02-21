package com.thinkinginjava.Initialize_clean.example.chapter5_4.ex5_4_1;

import com.thinkinginjava.util.Print;

/**
 * @Author: monika
 * @Date: 2018/11/10 21:16
 * @Version: 1.0
 * @Description: (1) 各个重载构造器之间可以通过this关键字进行调用，
 *                 一个构造器中只能调用一个构造器但不能调用两个构造器。
 *               (2) 必须将构造器调用置于构造器内的最起始处，否则编译器会报错。
 *               (3) 除构造器外，编译器进制在其他任何方法中调用构造器。
 */
public class Flower {
    int petalCount = 0;
    String s = "initial value";
    Flower(int petals) {
        petalCount = petals;
        Print.print("Constructor w/ int arg only, petalCount= "
                + petalCount);
    }
    Flower(String ss) {
        Print.print("Constructor w/ String arg only, s = " + ss);
        s = ss;
    }
    Flower(String s, int petals) {
        this(petals);
//!    this(s); // Can't call two!
        this.s = s; // Another use of "this"
        Print.print("String & int args");
    }
    Flower() {
        this("hi", 47);
        Print.print("default constructor (no args)");
    }
    void printPetalCount() {
//! this(11); // Not inside non-constructor!
        Print.print("petalCount = " + petalCount + " s = "+ s);
    }
    public static void main(String[] args) {
        Flower x = new Flower();
        x.printPetalCount();
    }
}
/**输出：
 * Constructor w/ int arg only, petalCount= 47
 * String & int args
 * default constructor (no args)
 * petalCount = 47 s = hi
 */