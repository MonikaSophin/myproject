package com.thinkinginjava.operators.exercise;

/**page 43
 *
 * 练习4:编写一个计算速度的程序，它所使用的距离和时间都是常量。
 */
class VelocityCalculator {
    static float velocity (float d, float t) {
        if(t == 0) return 0f;
        else return d/t;
    }
}
public class Ex04 {
    public static void main(String[] args) {
        float d = 565.3f;
        float t = 3.6f;
        System.out.println("Distance: " + d);
        System.out.println("Time: " + t);
        float v = VelocityCalculator.velocity(d, t);
        System.out.println("Velocity: " + v);
    }
}
