package com.thinkinginjava.reusing_classes.exercise.chapter7_2;

/**
 * @Author: monika
 * @Date: 2018/11/14 21:52
 * @Version: 1.0
 * @Description: page 130
 * 练习08：创建一个基类，它仅有一个非默认构造器；再创建一个导出类，它带有默认构造器和非默认构造器。
 * 在导出类的构造器中调用基类的构造器。
 */
class A2 {
    A2(char c, int i) {
        System.out.println("A2(char, int)");}
}
public class Ex08 extends A2{
    private char c;
    private int i;
    Ex08() {
        super('z', 3);
        System.out.println("Ex8()");
    }
    Ex08(char a, int j) {
        super(a, j);
        c = a;
        i = j;
        System.out.println("Ex8(char,int)");
    }
    public static void main(String[] args) {
        Ex08 ex1 = new Ex08();
        Ex08 ex2 = new Ex08('b', 2);
    }
}
/**输出：
 * A2(char, int)
 * Ex8()
 * A2(char, int)
 * Ex8(char,int)
 */