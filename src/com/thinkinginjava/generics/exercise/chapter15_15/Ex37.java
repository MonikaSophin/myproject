package com.thinkinginjava.generics.exercise.chapter15_15;

import java.util.Date;

/**
 * @author: XueYing.Cao
 * @date: 2019/2/18
 * @description: page 414
 * 练习37：向Mixins.java中添加一个新的混型类，将其混入到Mixin中，并展示其是可以
 * 工作的。
 */
interface TimeStamped { long getStamp(); }
class TimeStampedImp implements TimeStamped {
    private final long timeStamp;
    public TimeStampedImp() { timeStamp = new Date().getTime(); }
    @Override
    public long getStamp() { return timeStamp; }
}

interface SerialNumbered { long getSerilaNumber(); }
class SerialNumberedImp implements SerialNumbered {
    private static long counter = 1;
    private final long serialNumber = counter++;
    @Override
    public long getSerilaNumber() { return serialNumber; }
}

interface Basic {
    void set(String val);
    String get();
}
class BasicImp implements Basic {
    private String value;
    @Override
    public void set(String val) { value = val; }
    @Override
    public String get() { return value; }
}

interface GenericType<T> {
    String getType();
}
class GenericTypeImp<T> implements GenericType<T> {
    private T element;
    GenericTypeImp(T element) { this.element = element; }
    @Override
    public String getType() {
        return element.getClass().getSimpleName();
    }
}

class Mixin extends BasicImp implements TimeStamped, SerialNumbered, GenericType<Mixin> {
    private TimeStamped timeStamped = new TimeStampedImp();
    private SerialNumbered serialNumbered = new SerialNumberedImp();
    private GenericType<BasicImp> genericType = new GenericTypeImp<>(new BasicImp());
    @Override
    public long getStamp() { return timeStamped.getStamp(); }
    @Override
    public long getSerilaNumber() { return serialNumbered.getSerilaNumber(); }
    @Override
    public String getType() { return genericType.getType(); }
}
public class Ex37 {
    public static void main(String[] args) {
        Mixin mixin1 = new Mixin();
        Mixin mixin2 = new Mixin();
        mixin1.set("test string 1");
        mixin2.set("test string 2");
        System.out.println(mixin1.getType() + " " + mixin1.get() + " " + mixin1.getStamp() + " " + mixin1.getSerilaNumber());
        System.out.println(mixin2.getType() + " " + mixin2.get() + " " + mixin2.getStamp() + " " + mixin2.getSerilaNumber());
    }
}
/**output(70% match):
 * BasicImp test string 1 1550460611090 1
 * BasicImp test string 2 1550460611090 2
 */