package com.thinkinginjava.generics.exercise.chapter15_4;

/**
 * @Author: monika
 * @Date: 2019/2/2 21:43
 * @Version: 1.0
 * @Description: page 362
 * 练习09：修改GenericMethods.java类，使f()可以接受三个类型各不相同的参数。
 */
public class Ex09 {
    public <X, Y, Z> void f(X x, Y y, Z z) {
        System.out.println(String.format("X[%s] Y[%s] Z[%s]",
                x.getClass().getName(),
                y.getClass().getName(),
                z.getClass().getName()));
    }

    public static void main(String[] args) {
        Ex09 ex09 = new Ex09();
        short s = 1;
        byte b = 1;
        ex09.f(s, 1, 1L);
        ex09.f(1.0F, 1.0, " ");
        ex09.f(b, 'c', true);
    }
}
/**output:
 * X[java.lang.Short] Y[java.lang.Integer] Z[java.lang.Long]
 * X[java.lang.Float] Y[java.lang.Double] Z[java.lang.String]
 * X[java.lang.Byte] Y[java.lang.Character] Z[java.lang.Boolean]
 */