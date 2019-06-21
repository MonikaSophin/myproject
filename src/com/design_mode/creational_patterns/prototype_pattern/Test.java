package com.design_mode.creational_patterns.prototype_pattern;

/**
 * @author: XueYing.Cao
 * @date: 2019/6/21
 * @description:
 */
public class Test {
    public static void main(String[] args) {
        ShapeCache.loadCache();

        Shape clonedShape = ShapeCache.getShape("1");
        System.out.println("Shape : " + clonedShape.getType());

        Shape clonedShape2 = ShapeCache.getShape("2");
        System.out.println("Shape : " + clonedShape2.getType());
    }
}
/**output:
 * Shape : Circle
 * Shape : Square
 */