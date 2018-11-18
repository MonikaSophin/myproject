package com.thinkinginjava.reusing_classes.exercise.chapter7_7;

/**
 * @Author: monika
 * @Date: 2018/11/17 19:07
 * @Version: 1.0
 * @Description: page 140
 * 练习16：创建一个名为Amphibian的类。由此继承产生一个称为Frog的类。在基类中设置
 * 适当的方法。在main()中，创建一个Frog并向上转型至Amphibian,然后说明所有方法都可以工作。
 */
class Amphibian {
    protected void swim() { System.out.println("Amphibian swim"); }
    protected void speak() { System.out.println("Amphibian speak"); }
    void eat() { System.out.println("Amphibian eat"); }
    static void grow(Amphibian a) {
        System.out.println("Amphibian grow");
        a.eat();
    }
}

class Frog extends Amphibian { }

public class Ex16 {
    public static void main(String[] args) {
        Frog f = new Frog();
        // call base-class methods:
        f.swim();
        f.speak();
        f.eat();
        // upcast Frog to Amphibian argument:
        Amphibian.grow(f);
    }
}
/**输出：
 * Amphibian swim
 * Amphibian speak
 * Amphibian eat
 * Amphibian grow
 * Amphibian eat
 */