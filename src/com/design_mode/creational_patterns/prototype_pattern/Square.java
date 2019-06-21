package com.design_mode.creational_patterns.prototype_pattern;

/**
 * @author: XueYing.Cao
 * @date: 2019/6/21
 * @description:
 */
public class Square extends Shape {

    public Square() {
        type = "Square";
    }

    @Override
    public void draw() {
        System.out.println("Inside Square::draw() method.");
    }

}
