package com.thinkinginjava.arrays.exercise.chapter16_7;

import java.util.Arrays;

/**
 * @author: XueYing.Cao
 * @date: 2019/2/21
 * @description: page 452
 * 练习19：创建一个类，它有一个用构造器中的参数初始化的int域。创建由这个类的对象
 * 构成的两个数组，每个数组都使用了相同的初始化值，然后展示它们不相等的Arrays.equals()
 * 声明。在你的类中添加一个equals()方法来解决此问题。
 */
class A {
    private int i;
    public A(int i) { this.i = i; }
    public int getI() { return i; }
    public void setI(int i) { this.i = i; }
    @Override
    public String toString() { return "A{" + "i=" + i + '}'; }

    @Override
    public boolean equals(Object obj) {
        A a = (A) obj;
        if (this.i == a.getI())
            return true;
        return false;
    }

}

public class Ex19 {
    public static void main(String[] args) {
        A[] a1 = new A[5];
        A[] a2 = new A[5];
        Arrays.fill(a1, new A(8));
        Arrays.fill(a2, new A(8));

        System.out.println(String.format("A[] a1 = %s", Arrays.toString(a1)));
        System.out.println(String.format("A[] a2 = %s", Arrays.toString(a2)));
        System.out.println(String.format("Arrays.equals(a1, a2): %s", Arrays.equals(a1, a2)));
    }
}
/**output:
 * A[] a1 = [A{i=8}, A{i=8}, A{i=8}, A{i=8}, A{i=8}]
 * A[] a2 = [A{i=8}, A{i=8}, A{i=8}, A{i=8}, A{i=8}]
 * Arrays.equals(a1, a2): true
 */