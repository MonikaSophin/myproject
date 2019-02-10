package com.thinkinginjava.generics.exercise.chapter15_4;

/**
 * @Author: monika
 * @Date: 2019/2/2 21:55
 * @Version: 1.0
 * @Description: page 362
 * 练习10：修改前一个练习，将方法f()的其中一个参数修改为非参数化的类型。
 */
public class Ex10 {
    public <X, Y> void f(X x, Y y, int z) {
        System.out.println(String.format("X[%s] Y[%s] Z[java.lang.Integer]",
                x.getClass().getName(),
                y.getClass().getName()));
    }

    public static void main(String[] args) {
        Ex10 ex10 = new Ex10();
        ex10.f(1, 1L ,1);
        ex10.f(1.0f, 1.0D ,1);
        ex10.f(true, 'c' ,1);
    }
}
/**output:
 * X[java.lang.Integer] Y[java.lang.Long] Z[java.lang.Integer]
 * X[java.lang.Float] Y[java.lang.Double] Z[java.lang.Integer]
 * X[java.lang.Boolean] Y[java.lang.Character] Z[java.lang.Integer]
 */