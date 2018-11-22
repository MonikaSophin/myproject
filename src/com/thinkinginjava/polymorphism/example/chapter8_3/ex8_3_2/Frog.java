package com.thinkinginjava.polymorphism.example.chapter8_3.ex8_3_2;

/**
 * @Author: monika
 * @Date: 2018/11/21 21:18
 * @Version: 1.0
 * @Description:    某个子对象要依赖于其他对象，销毁的顺序应该和初始化顺序相反。
 *                对于字段，则意味着与声明的顺序相反（因为字段的初始化时按照声明
 *                的顺序进行的）。对于基类，应该首先对其导出类进行清理，然后才是
 *                基类。这是因为导出类的清理可能会调用基类中的某些方法，所以需要
 *                使基类中的构件仍起作用而不应过早地销毁它们。
 */
class Characteristic {
    private String s;
    Characteristic(String s) {
        this.s = s;
        System.out.println("Creating Characteristic " + s);
    }
    protected void dispose() {
        System.out.println("disposing Characteristic " + s);
    }
}

class Description {
    private String s;
    Description(String s) {
        this.s = s;
        System.out.println("Creating Description " + s);
    }
    protected void dispose() {
        System.out.println("disposing Description " + s);
    }
}

class LivingCreature {
    private Characteristic p =
            new Characteristic("is alive");
    private Description t =
            new Description("Basic Living Creature");
    LivingCreature() {
        System.out.println("LivingCreature()");
    }
    protected void dispose() {
        System.out.println("LivingCreature dispose");
        t.dispose();
        p.dispose();
    }
}

class Animal extends LivingCreature {
    private Characteristic p =
            new Characteristic("has heart");
    private Description t =
            new Description("Animal not Vegetable");
    Animal() { System.out.println("Animal()"); }
    protected void dispose() {
        System.out.println("Animal dispose");
        t.dispose();
        p.dispose();
        super.dispose();
    }
}

class Amphibian extends Animal {
    private Characteristic p =
            new Characteristic("can live in water");
    private Description t =
            new Description("Both water and land");
    Amphibian() {
        System.out.println("Amphibian()");
    }
    protected void dispose() {
        System.out.println("Amphibian dispose");
        t.dispose();
        p.dispose();
        super.dispose();
    }
}

public class Frog extends Amphibian {
    private Characteristic p = new Characteristic("Croaks");
    private Description t = new Description("Eats Bugs");
    public Frog() { System.out.println("Frog()"); }
    protected void dispose() {
        System.out.println("Frog dispose");
        t.dispose();
        p.dispose();
        super.dispose();
    }
    public static void main(String[] args) {
        Frog frog = new Frog();
        System.out.println("Bye!");
        frog.dispose();
    }
}
/**输出：
 * Creating Characteristic is alive
 * Creating Description Basic Living Creature
 * LivingCreature()
 * Creating Characteristic has heart
 * Creating Description Animal not Vegetable
 * Animal()
 * Creating Characteristic can live in water
 * Creating Description Both water and land
 * Amphibian()
 * Creating Characteristic Croaks
 * Creating Description Eats Bugs
 * Frog()
 * Bye!
 * Frog dispose
 * disposing Description Eats Bugs
 * disposing Characteristic Croaks
 * Amphibian dispose
 * disposing Description Both water and land
 * disposing Characteristic can live in water
 * Animal dispose
 * disposing Description Animal not Vegetable
 * disposing Characteristic has heart
 * LivingCreature dispose
 * disposing Description Basic Living Creature
 * disposing Characteristic is alive
 */