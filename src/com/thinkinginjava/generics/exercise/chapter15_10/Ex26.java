package com.thinkinginjava.generics.exercise.chapter15_10;

/**
 * @author: XueYing.Cao
 * @date: 2019/2/14
 * @description: page 391
 * 练习26：使用Number和Integer证明数组的协变性。
 */
public class Ex26 {
    public static void main(String[] args) {
        Number[] numbers = new Integer[3];
        numbers[0] = new Integer(0);
        numbers[1] = new Integer(1);
        numbers[2] = new Integer(2);
        // 抽象类Number,无法实例化:
        // numbers[0] = new Number();
        try { // 编译OK;运行时ArrayStoreException:
            numbers[1] = new Double(3.4);
        } catch(Exception e) {
            System.out.println(e);
        }
        for(Number n : numbers)
            System.out.println(n);

        // 编译错误：不兼容的类型:
        // Integer[] ints = numbers;

        // for(Integer n : numbers)
        //	System.out.println(n);

        //即使运行时类型是Integer:
        for(Number n : numbers)
            System.out.println(n.getClass().getSimpleName());
    }
}
/**output:
 * java.lang.ArrayStoreException: java.lang.Double
 * 0
 * 1
 * 2
 * Integer
 * Integer
 * Integer
 */