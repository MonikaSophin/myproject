package com.thinkinginjava.generics.example.chapter15_2;

/**
 * @author: XueYing.Cao
 * @date: 2019/1/30
 * @description:
 */
public class Holder3<T> {
    private  T a;
    public Holder3(T a) { this.a = a; }
    public T getA() { return a; }
    public void setA(T a) { this.a = a; }

    public static void main(String[] args) {
        Holder3<Automobile> h3 = new Holder3<>(new Automobile());
//        h3.setA("Not an Automobile");
//        h3.setA(1);
    }
}
