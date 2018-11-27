package com.thinkinginjava.interfaces.exercise.chapter9_4;

/**
 * @Author: monika
 * @Date: 2018/11/26 21:00
 * @Version: 1.0
 * @Description: page 179
 * 练习12：在Adventure.java中，按照其他接口的样式，增加一个CanClimb接口。
 */
interface CanClimb{
    void climb();
}

interface CanFight {
    void fight();
}

interface CanSwim {
    void swim();
}

interface CanFly {
    void fly();
}

class ActionCharacter {
    public void fight() {}
}

class Hero extends ActionCharacter
        implements CanFight, CanSwim, CanFly,CanClimb {
    public void swim() {}
    public void fly() {}
    public void climb() {}
}

public class Ex12 {
    public static void t(CanFight x) { x.fight(); }
    public static void u(CanSwim x) { x.swim(); }
    public static void v(CanFly x) { x.fly(); }
    public static void w(ActionCharacter x) { x.fight(); }
    public static void c(CanClimb x) { x.climb(); }
    public static void main(String[] args) {
        Hero h = new Hero();
        c(h); // Treat it as a CanClimb
        t(h); // Treat it as a CanFight
        u(h); // Treat it as a CanSwim
        v(h); // Treat it as a CanFly
        w(h); // Treat it as an ActionCharacter
    }

}
