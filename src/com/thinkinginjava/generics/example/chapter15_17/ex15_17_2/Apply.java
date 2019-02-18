package com.thinkinginjava.generics.example.chapter15_17.ex15_17_2;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author: monika
 * @Date: 2019/2/18 20:59
 * @Version: 1.0
 * @Description:
 */
public class Apply {
    public static <T, S extends Iterable<? extends T>> void
    apply(S seq, Method f, Object ... args){
        try{
            for (T t : seq)
                f.invoke(t, args);
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

class FilledList<T> extends ArrayList<T> {
    public FilledList(Class<? extends T> type, int size) {
        try{
            for (int i = 0; i < size; i++)
                add(type.newInstance());
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

class Shape {
    public void rotate() {
        System.out.println(getClass().getSimpleName() + " rotate");
    }
    public void resize(int newSize) {
        System.out.println(getClass().getSimpleName() + " resize " + newSize);
    }
}

class Square extends Shape {}

class ApplyTest {
    public static void main(String[] args) throws NoSuchMethodException {
        List<Shape> shapes = new ArrayList<>();
        for (int i = 0; i < 2; i++)
            shapes.add(new Shape());
        Apply.apply(shapes, Shape.class.getMethod("rotate"));
        Apply.apply(shapes, Shape.class.getMethod("resize", int.class), 5);
        System.out.println();

        List<Square> squares = new ArrayList<>();
        for (int i = 0; i < 2; i++)
            squares.add(new Square());
        Apply.apply(squares, Shape.class.getMethod("rotate"));
        Apply.apply(squares, Shape.class.getMethod("resize", int.class), 3);
        System.out.println();

        Apply.apply(new FilledList<>(Shape.class, 2),
                Shape.class.getMethod("rotate"));
        Apply.apply(new FilledList<>(Square.class,2),
                Shape.class.getMethod("rotate"));
        System.out.println();

        SimpleQueue<Shape> shapeQ = new SimpleQueue<>();
        for (int i = 0; i < 2; i++) {
            shapeQ.add(new Shape());
            shapeQ.add(new Square());
        }
        Apply.apply(shapeQ, Shape.class.getMethod("rotate"));
    }
}
/**output:
 * Shape rotate
 * Shape rotate
 * Shape resize 5
 * Shape resize 5
 *
 * Square rotate
 * Square rotate
 * Square resize 3
 * Square resize 3
 *
 * Shape rotate
 * Shape rotate
 * Square rotate
 * Square rotate
 *
 * Shape rotate
 * Square rotate
 * Shape rotate
 * Square rotate
 */