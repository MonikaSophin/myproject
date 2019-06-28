package com.design_mode.structural_patterns.facade_pattern;

/**
 * @author: XueYing.Cao
 * @date: 2019/6/28
 * @description:
 */
public class Test {
    public static void main(String[] args) {
        ShapeMaker shapeMaker = new ShapeMaker();

        shapeMaker.drawCircle();
        shapeMaker.drawRectangle();
        shapeMaker.drawSquare();
    }
}
/**
 * Circle::draw()
 * Rectangle::draw()
 * Square::draw()
 */