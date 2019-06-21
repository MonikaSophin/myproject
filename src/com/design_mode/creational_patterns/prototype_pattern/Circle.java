package com.design_mode.creational_patterns.prototype_pattern;

/**
 * @author: XueYing.Cao
 * @date: 2019/6/21
 * @description:
 */
public class Circle extends Shape {

    public Circle() {
        type = "Circle";
    }

    @Override
    public void draw() {
        System.out.println("Inside Circle::draw() method.");
    }

}