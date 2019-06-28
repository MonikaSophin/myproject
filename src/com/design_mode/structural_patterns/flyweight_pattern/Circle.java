package com.design_mode.structural_patterns.flyweight_pattern;

/**
 * @author: XueYing.Cao
 * @date: 2019/6/28
 * @description:
 * 步骤2:
 * 创建实现Shape接口的实体类。
 */
public class Circle implements Shape {

    private String color;
    //坐标x
    private int x;
    //坐标y
    private int y;
    //半径
    private int radius;

    public Circle(String color) {
        this.color = color;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public void draw() {
        System.out.println("Circle: Draw() [Color : " + color
                +", x : " + x +", y :" + y +", radius :" + radius);
    }
}
