package com.thinkinginjava.enumerated_types.example.chapter19_3;

/**
 * @author: XueYing.Cao
 * @date: 2019/4/8
 * @description:
 */
enum Signal {
    GREEN, YELLOW, RED,
}

public class TrafficLight {
    Signal color = Signal.RED;
    public void change() {
        switch (color) {
            case RED:
                color = Signal.GREEN;
                break;
            case GREEN:
                color = Signal.YELLOW;
                break;
            case YELLOW:
                color = Signal.RED;
                break;
        }
    }

    @Override
    public String toString() {
        return "The traffic light is " + color;
    }

    public static void main(String[] args) {
        TrafficLight t = new TrafficLight();
        for (int i = 0; i < 7; i++) {
            System.out.println(t);
            t.change();
        }
    }
}
/**output:
 * The traffic light is RED
 * The traffic light is GREEN
 * The traffic light is YELLOW
 * The traffic light is RED
 * The traffic light is GREEN
 * The traffic light is YELLOW
 * The traffic light is RED
 */