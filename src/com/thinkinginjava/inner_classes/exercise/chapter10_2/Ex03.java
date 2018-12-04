package com.thinkinginjava.inner_classes.exercise.chapter10_2;

/**
 * @Author: monika
 * @Date: 2018/11/29 21:55
 * @Version: 1.0
 * @Description: page 192
 * 练习03：修改练习01，使得Outer类包含一个private String域（由构造器初始化）。
 * 而Inner包含一个显示这个域的toSting()方法。创建一个Inner类型的对象并显示它。
 */
class Outer {
    private String string;
    public Outer(String string) {
        System.out.println("初始化Outer");
        this.string = string;
    }
    public class Inner {
        public Inner() { System.out.println("初始化Outer.Inner"); }
        @Override
        public String toString() { return "Outer.Inner-->"+string; }
    }
    public Inner getInner() { return new Inner(); }
}

public class Ex03 {
    public static void main(String[] args) {
        Outer outer = new Outer("Outer的String域");
        Outer.Inner inner = outer.getInner();
        System.out.println(inner);
    }

}
/**输出：
 * 初始化Outer
 * 初始化Outer.Inner
 * Outer.Inner-->Outer的String域
 */