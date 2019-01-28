package com.thinkinginjava.type_information.exercise.chapter14_2;

/**
 * @Author: monika
 * @Date: 2019/1/25 21:38
 * @Version: 1.0
 * @Description: page 318
 * 练习04：修改前一个练习，让你的程序在执行向下转型之前先运用instanceof检查类型。
 */
public class Ex04 {
    public static void main(String[] args) {
        Rhomboid rhomboid =  new Rhomboid();
        Shape shape = (Shape)rhomboid;
        if (shape instanceof Circle) {
            // Circle circle = (Circle) shape;
        }else {
            System.out.println("(Shape)rhomboid is not a Circle");
        }
    }
}
/**output:
 * (Shape)rhomboid is not a Circle
 */