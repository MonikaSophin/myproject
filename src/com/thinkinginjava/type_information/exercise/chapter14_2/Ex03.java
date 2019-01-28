package com.thinkinginjava.type_information.exercise.chapter14_2;

/**
 * @Author: monika
 * @Date: 2019/1/25 21:30
 * @Version: 1.0
 * @Description: page 318
 * 练习03：将Rhomboid(菱形)加入Shapes.java中。创建一个Rhomboid，将其向上转型为Shape,
 * 然后向下转型回Rhomboid。试着将其向下转型为Circle，看看会发生什么。
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

class Rhomboid extends Shape {
    @Override
    public String toString() { return "Rhomboid"; }
}

public class Ex03 {
    public static void main(String[] args) {
        Rhomboid rhomboid =  new Rhomboid();
        Shape shape = rhomboid;
        Circle circle = (Circle) shape;
    }
}
/**
 * Exception in thread "main" java.lang.ClassCastException: Rhomboid cannot be cast to Circle
 * 	at com.thinkinginjava.type_information.exercise.chapter14_2.Ex03.main(Ex03.java:31)
 */