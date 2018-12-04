package com.thinkinginjava.inner_classes.exercise.chapter10_1;

/**
 * @Author: monika
 * @Date: 2018/11/28 21:53
 * @Version: 1.0
 * @Description: page 191
 * 练习01：编写一个名为Outer的类，它包含一个名为Inner的类。在Outer中添加一个方法，
 * 它返回一个Inner类型的对象。在main()中，创建并初始化一个指向某个Inner对象的引用。
 */
public class Ex01 {
    public class Inner{
        public Inner() { System.out.println("初始化Ex01.Inner"); }
        @Override
        public String toString() { return "Ex01.Inner"; }
    }

    public Inner getInner(){ return new Inner(); }

    public static void main(String[] args) {
        Ex01 ex01 = new Ex01();
        Inner inner = ex01.getInner();
        System.out.println(inner);

        Ex01.Inner inner1 = ex01.getInner();
        System.out.println(inner1);
    }
}
/**输出：
 * 初始化Ex01.Inner
 * Ex01.Inner
 * 初始化Ex01.Inner
 * Ex01.Inner
 */