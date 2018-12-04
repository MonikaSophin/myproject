package com.thinkinginjava.inner_classes.exercise.chapter10_1;

/**
 * @Author: monika
 * @Date: 2018/11/28 22:02
 * @Version: 1.0
 * @Description: 如果想从外部类的非静态方法之外的任意位置创建某个内部类的对象，那么必须像在
 *            main()方法那样，具体地指明这个对象的类型：OuterClassName.InnerClassName。
 */
public class Ex01Test {
    public static void main(String[] args) {
        Ex01 ex01 = new Ex01();
        // 编译出错
        //! Inner inner = ex01.getInner();
        //! System.out.println(inner);

        Ex01.Inner inner1 = ex01.getInner();
        System.out.println(inner1);
    }
}
/**输出：
 * 初始化Ex01.Inner
 * Ex01.Inner
 */