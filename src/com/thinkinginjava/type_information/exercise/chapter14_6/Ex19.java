package com.thinkinginjava.type_information.exercise.chapter14_6;

import java.lang.reflect.Constructor;

/**
 * @Author: monika
 * @Date: 2019/1/28 21:35
 * @Version: 1.0
 * @Description: page 337
 * 练习19：在ToyTest.java中，使用反射机制，通过非默认构造器创建Toy对象。
 */
interface HasBatteries {}
interface Waterproof {}
interface Shoots {}

class Toy {
    private String s;
    private int i;
    public String getS() { return s; }
    public void setS(String s) { this.s = s; }
    public int getI() { return i; }
    public void setI(int i) { this.i = i; }
    public Toy() {}
    public Toy(String s, int i) {
        this.s = s;
        this.i = i;
    }
}

class FancyToy extends Toy implements HasBatteries, Waterproof, Shoots{
    private String s;
    private int i;
    public String getS() { return s; }
    public void setS(String s) { this.s = s; }
    public int getI() { return i; }
    public void setI(int i) { this.i = i; }
    public FancyToy() {}
    public FancyToy(String s, int i) {
        super(s, i);
        this.s = s;
        this.i = i;
    }
}

public class Ex19 {
    public static void main(String[] args) {
        Class c = null;
        try {
            c = Class.forName("com.thinkinginjava.type_information.exercise.chapter14_6.FancyToy");
            Constructor constructor = c.getConstructor(String.class, int.class);
            Object o = constructor.newInstance("test14", 666);
            Toy toy = (Toy)o;
            System.out.println(toy);
            System.out.println(toy.getS());
            System.out.println(toy.getI());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
/**output:
 * com.thinkinginjava.type_information.exercise.chapter14_6.FancyToy@4554617c
 * test14
 * 666
 */