package com.thinkinginjava.inner_classes.example.chapter10_7.ex10_7_1;

/**
 * @Author: monika
 * @Date: 2018/12/8 20:30
 * @Version: 1.0
 * @Description:
 * 1.如果你想要创建某些公共代码，使得它们可以被某个接口的所有不同实现所共用，
 * 那么使用接口内部的嵌套类会显得很方便。
 */
public class TestBed {
    public void f(){ System.out.println("f()"); }
    public static class Tester{
        public static void main(String[] args) {
            TestBed testBed = new TestBed();
            testBed.f();
        }
    }
}
/**输出：
 * f()
 */