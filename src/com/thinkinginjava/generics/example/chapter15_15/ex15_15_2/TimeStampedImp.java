package com.thinkinginjava.generics.example.chapter15_15.ex15_15_2;

import java.util.Date;

/**
 * @author: XueYing.Cao
 * @date: 2019/2/18
 * @description:
 */
public class TimeStampedImp implements TimeStamped {
    private final long timeStamp;
    public TimeStampedImp() { timeStamp = new Date().getTime(); }
    @Override
    public long getStamp() { return timeStamp; }
}
