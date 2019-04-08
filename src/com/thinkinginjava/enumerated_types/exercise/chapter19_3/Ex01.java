package com.thinkinginjava.enumerated_types.exercise.chapter19_3;

import com.thinkinginjava.enumerated_types.example.chapter19_3.TrafficLight;
import com.thinkinginjava.enumerated_types.exercise.chapter19_3.enumerated.Signal;
import static com.thinkinginjava.enumerated_types.exercise.chapter19_3.enumerated.Signal.*;

/**
 * @author: XueYing.Cao
 * @date: 2019/4/8
 * @description: page 594
 * 练习01：修改{@link TrafficLight},使用static import, 使之无需用enum类型修饰其实例。
 */
public class Ex01 {
    Signal color = RED;
    public void change() {
        switch (color) {
            case RED:
                color = GREEN;
                break;
            case GREEN:
                color = YELLOW;
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