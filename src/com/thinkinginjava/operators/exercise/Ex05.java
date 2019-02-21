package com.thinkinginjava.operators.exercise;

import com.thinkinginjava.util.Print;

/**page 45
 *
 * 练习5:创建一个名为Dog的类，它包含两个String域：name和says。在main()方法中.
 *  创建两个Dog对象，一个名为spot（它的叫声为“Ruff！”），另一个名为scruffy（它的、
 *  叫声为“Wurf!”）。然后显示他们的名字和叫声。
 */
class Dog{
    String name;
    String says;

    public Dog() { }
    public Dog(String name, String says) {
        this.name = name;
        this.says = says;
    }

    void setName(String name) { this.name = name; }
    void setSays(String says) { this.says = says; }
    void showName() { Print.print(name); }
    void speak() { Print.print(says); }
}

public class Ex05 {
    public static void main(String[] args) {
        Dog spot = new Dog();
        spot.setName("Spot");
        spot.setSays("Ruff!");
        Dog scruffy = new Dog();
        scruffy.setName("Scruffy");
        scruffy.setSays("Wurf!");
        spot.showName();
        spot.speak();
        scruffy.showName();
        scruffy.speak();
    }
}
