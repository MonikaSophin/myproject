package com.thinkinginjava.generics.example.chapter15_17.ex15_17_1;

import com.thinkinginjava.generics.example.chapter15_16.Robot;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * @author: XueYing.Cao
 * @date: 2019/2/18
 * @description:
 */
class Mime { // 没有实现Performs接口
    public void walkAgainstTheWind() {}
    public void sit() { System.out.println("Mime can sit"); }
    public void pushInvisibleWalls() {}
    @Override
    public String toString() { return "Mime"; }
}

class SmartDog { // 没有实现Performs接口
    public void speak() { System.out.println("Woof!"); }
    public void sit() { System.out.println("Sitting"); }
    public void reproduce() {}
}

class CommunicateReflectively {
    public static void perform(Object speaker) {
        Class<?> spkr = speaker.getClass();
        try {
            try {
                Method speak = spkr.getMethod("speak");
                speak.invoke(speaker);
            } catch (NoSuchMethodException e) {
                System.out.println(speaker + " cannot speak");
            }
            try {
                Method sit = spkr.getMethod("sit");
                sit.invoke(speaker);
            } catch (NoSuchMethodException e) {
                System.out.println(speaker + " cannot sit");
            }
        }catch (Exception e) {
            throw new RuntimeException(speaker.toString(), e);
        }
    }
}

public class LatentReflection {
    public static void main(String[] args) {
        CommunicateReflectively.perform(new SmartDog());
        CommunicateReflectively.perform(new Robot());
        CommunicateReflectively.perform(new Mime());
        System.out.println(new Date().getTime());
    }
}
/**output:
 * Woof!
 * Sitting
 * Click!
 * Clank!
 * Mime cannot speak
 * Mime can sit
 */