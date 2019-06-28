package com.design_mode.structural_patterns.flyweight_pattern;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: XueYing.Cao
 * @date: 2019/6/28
 * @description:
 * 步骤3:
 * 创建一个工厂，生成基于给定信息的实体类的对象。
 */
public class ShapeFactory {
    public static final Map<String, Shape> circleMap = new HashMap<>();

    public static Shape getCircle(String color) {
        Circle circle = (Circle) circleMap.get(color);
        if (circle == null) {
            circle = new Circle(color);
            circleMap.put(color, circle);
            System.out.println("Creating circle of color : " + color);
        }
        return circle;
    }
}
