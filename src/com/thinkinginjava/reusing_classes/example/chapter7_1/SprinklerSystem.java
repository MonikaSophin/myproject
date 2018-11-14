package com.thinkinginjava.reusing_classes.example.chapter7_1;

/**
 * @Author: monika
 * @Date: 2018/11/14 20:56
 * @Version: 1.0
 * @Description: 组合语法：在策略模式中一种常见的用法，将现有的对象置于你编写的类中。
 * 一般使用接口，这样可以是这个对象可以替代。
 */
class WaterSource {
    private String s;
    WaterSource() {
        System.out.println("WaterSource()");
        s = "Constructed";
    }
    public String toString() {
        return s;
    }
}

public class SprinklerSystem {
    private String valve1, valve2, valve3, valve4;
    private WaterSource source = new WaterSource();
    private int i;
    private float f;
    public String toString() {
        return
                "valve1 = " + valve1 + " " +
                        "valve2 = " + valve2 + " " +
                        "valve3 = " + valve3 + " " +
                        "valve4 = " + valve4 + "\n" +
                        "i = " + i + " " + "f = " + f + " " +
                        "source = " + source;
    }
    public static void main(String[] args) {
        SprinklerSystem sprinklers = new SprinklerSystem();
        System.out.println(sprinklers);
    }
}
/**输出：
 * WaterSource()
 * valve1 = null valve2 = null valve3 = null valve4 = null
 * i = 0 f = 0.0 source = Constructed
 */