package com.thinkinginjava.type_information.example.chapter14_1;

import java.util.Arrays;
import java.util.List;

/**
 * @Author: monika
 * @Date: 2019/1/14 21:06
 * @Version: 1.0
 * @Description:
 */
abstract class Shape {
    void draw() { System.out.println(this + ".draw()"); }
    @Override
    abstract public String toString();
}

class Circle extends Shape {
    @Override
    public String toString() { return "Circle"; }
}

class Square extends Shape {
    @Override
    public String toString() { return "Square"; }
}

class Triangle extends Shape {
    @Override
    public String toString() { return "Triangle"; }
}

public class Shapes {
    public static void main(String[] args) {
        List<Shape> shapeList = Arrays.asList(new Circle(), new Square(), new Triangle());
        for (Shape shape : shapeList) { shape.draw(); }
    }
}
/**output:
 * Circle.draw()
 * Square.draw()
 * Triangle.draw()
 */