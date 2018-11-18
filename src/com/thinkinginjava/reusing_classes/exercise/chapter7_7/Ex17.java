package com.thinkinginjava.reusing_classes.exercise.chapter7_7;

/**
 * @Author: monika
 * @Date: 2018/11/17 19:14
 * @Version: 1.0
 * @Description: page 140
 * 练习17：修改练习16，使得Frog覆盖基类中方法的定义（令新定义使用相同的方法特征签名）。
 * 请留心main()中都发生了什么。
 */
class Frog17 extends Amphibian {
    @Override protected void swim() { System.out.println("Frog swim"); }
    @Override protected void speak() { System.out.println("Frog speak"); }
    @Override void eat() { System.out.println("Frog eat"); }
    static void grow(Amphibian a) {
        System.out.println("Frog grow");
        a.eat();
    }
}

public class Ex17 {
    public static void main(String[] args) {
        Frog17 f = new Frog17();
        // call overridden base-class methods:
        f.swim();
        f.speak();
        f.eat();
        // upcast Frog17 to Amphibian argument:
        f.grow(f);
        // upcast Frog17 to Amphibian and call Amphibian method:
        Amphibian.grow(f);
    }
}
/**输出：
 * Frog swim
 * Frog speak
 * Frog eat
 * Frog grow
 * Frog eat
 * Amphibian grow
 * Frog eat
 */