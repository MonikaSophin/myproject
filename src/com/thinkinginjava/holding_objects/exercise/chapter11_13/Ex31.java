package com.thinkinginjava.holding_objects.exercise.chapter11_13;

import com.thinkinginjava.polymorphism.example.chapter8_2.ex8_2_2.Circle;
import com.thinkinginjava.polymorphism.example.chapter8_2.ex8_2_2.Shape;
import com.thinkinginjava.polymorphism.example.chapter8_2.ex8_2_2.Square;
import com.thinkinginjava.polymorphism.example.chapter8_2.ex8_2_2.Triangle;

import java.util.Iterator;
import java.util.Random;

/**
 * @Author: monika
 * @Date: 2018/12/22 15:01
 * @Version: 1.0
 * @Description: page 243
 * 练习31：修改polymorphism/shape/RandomShapeGenerator.java，使其成为一个Iterable。
 * 你需要添加一个接收元素数量为参数的构造器，这个数量是指在停止之前，你想用迭代器生成的元素的数
 * 量。验证这个程序可以工作。
 */
class RandomShapeGenerator implements Iterable<Shape> {
    private Shape[] shapes;
    private Random rand = new Random();

    public RandomShapeGenerator(int size) {
        shapes = new Shape[size];
        for (int i = 0; i < size; i++)
            shapes[i] = next();
    }

    private Shape next() {
        switch (rand.nextInt(3)) {
            default: return new Circle();
            case 0: return new Circle();
            case 1: return new Square();
            case 2: return new Triangle();
        }
    }

    @Override
    public Iterator<Shape> iterator() {
        return new Iterator() {
            private int index = 0;
            @Override
            public boolean hasNext() { return index < shapes.length; }
            @Override
            public Shape next() { return shapes[index++]; }
        };
    }
}

public class Ex31 {
    public static void main(String[] args) {
        RandomShapeGenerator r = new RandomShapeGenerator(6);
        for (Shape shape : r)
            shape.draw();
    }
}
/**output(随机):
 * Square.draw()
 * Circle.draw()
 * Triangle.draw()
 * Circle.draw()
 * Triangle.draw()
 * Triangle.draw()
 */