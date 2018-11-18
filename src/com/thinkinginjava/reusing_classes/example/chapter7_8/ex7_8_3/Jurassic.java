package com.thinkinginjava.reusing_classes.example.chapter7_8.ex7_8_3;

/**
 * @Author: monika
 * @Date: 2018/11/18 12:34
 * @Version: 1.0
 * @Description: final类
 *             1. 当将某个类的整体定义为final时（通过将关键字final置于它的定义之前），就表明了
 *             你不打算继承该类，而且也不允许别人这样做。换句话说，出于某种考虑，你对该类的设计永不
 *             需要做任何改动，或者出于安全的考虑，你不希望它有子类。
 *             2.由于final类禁止继承，所以final类中所有的方法都隐式指定为是final的，因为无法覆盖
 *             它们。在final类中可以添加final修饰词，但这不会增添任何意义。
 */
class SmallBrain {}

final class Dinosaur {
    int i = 7;
    int j = 1;
    SmallBrain x = new SmallBrain();
    void f() {}
}

//! class Further extends Dinosaur {}
// error: Cannot extend final class 'Dinosaur'

public class Jurassic {
    public static void main(String[] args) {
        Dinosaur n = new Dinosaur();
        n.f();
        n.i = 40;
        n.j++;
    }
}
