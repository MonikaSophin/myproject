package com.thinkinginjava.type_information.exercise.chapter14_2;

import java.util.Arrays;
import java.util.List;

/**
 * @Author: monika
 * @Date: 2019/1/25 21:44
 * @Version: 1.0
 * @Description: page 318
 * 练习05：实现Shapes.java中的rotate(Shape)方法，让它能判断它所旋转的是不是Circle
 * （如果是，就不执行）。
 */
public class Ex05 {
    public static void main(String[] args) {
        List<Shape> shapeList = Arrays.asList(new Circle(), new Square(), new Triangle(), new Rhomboid());
        for (Shape shape : shapeList) {
            shape.draw();
            rotate(shape);
        }
    }

    private static void rotate(Shape shape) {
        if (shape instanceof Circle)
            System.out.println("  no rotate");
        else
            System.out.println("  rotate");
    }
}
/**output:
 * Circle.draw()
 *   no rotate
 * Square.draw()
 *   rotate
 * Triangle.draw()
 *   rotate
 * Rhomboid.draw()
 *   rotate
 */