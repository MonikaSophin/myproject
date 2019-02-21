package com.thinkinginjava.operators.exercise;

import com.thinkinginjava.util.Print;

/**page 45
 *
 * 练习6：在练习5的基础上，创建一个新的Dog索引，并对其赋值为spot对象。
 * 测试用==和equals()方法比较所有引用的结果。
 */

public class Ex06 {
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
        Dog butch = new Dog();
        butch.setName("Butch");
        butch.setSays("Hello!");
        butch.showName();
        butch.speak();
        Print.print("Comparison: ");
        Print.print("spot == butch: " + (spot == butch));
        Print.print("spot.equals(butch): " + spot.equals(butch));
        Print.print("butch.equals(spot): " + butch.equals(spot));
        Print.print("Now assign: spot = butch");
        spot = butch;
        Print.print("Compare again: ");
        Print.print("spot == butch: " + (spot == butch));
        Print.print("spot.equals(butch): " + spot.equals(butch));
        Print.print("butch.equals(spot): " + butch.equals(spot));
        Print.print("Spot: ");
        spot.showName();
        spot.speak();
        Print.print("Butch: ");
        butch.showName();
        butch.speak();

    }
}
