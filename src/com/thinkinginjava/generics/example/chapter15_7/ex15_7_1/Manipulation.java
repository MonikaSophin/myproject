package com.thinkinginjava.generics.example.chapter15_7.ex15_7_1;

/**
 * @author: XueYing.Cao
 * @date: 2019/2/12
 * @description:
 */
class Manipulator<T> {
    private T obj;
    public Manipulator(T obj) { this.obj = obj; }
    public void manipulate() {
        //!! obj.f(); //编译错误
    }
}

public class Manipulation {
    public static void main(String[] args) {
        HasF hf = new HasF();
        Manipulator<HasF> manipulator = new Manipulator<>(hf);
        manipulator.manipulate();
    }
}
