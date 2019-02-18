package com.thinkinginjava.generics.example.chapter15_15.ex15_15_2;

/**
 * @author: XueYing.Cao
 * @date: 2019/2/18
 * @description:
 */
public class Mixin extends BasicImp implements TimeStamped, SerialNumbered {
    private TimeStamped timeStamped = new TimeStampedImp();
    private SerialNumbered serialNumbered = new SerialNumberedImp();
    @Override
    public long getStamp() { return timeStamped.getStamp(); }
    @Override
    public long getSerilaNumber() { return serialNumbered.getSerilaNumber(); }
}
