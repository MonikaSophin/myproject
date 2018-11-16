package com.thinkinginjava.reusing_classes.exercise.chapter7_1;

/**
 * @Author: monika
 * @Date: 2018/11/14 21:09
 * @Version: 1.0
 * @Description: page 127
 * 练习01：创建一个简单的类。在第二个类中，将一个引用定义为第一个类的对象。运用
 * 惰性初始化来实例化这个对象。
 */
class Simple{
    public Simple() {
        System.out.println("Simple()");
    }

    public String toString() {
        return "Simple() is Constructed";
    }
}

public class Ex01 {
    private Simple simple;
    public Ex01() {
        System.out.println("Ex01()");
    }
    public String toString() {
        if (simple==null) // 惰性初始化
            simple = new Simple();
        return "Ex01{" + "simple=" + simple + "}";
    }

    public static void main(String[] args) {
        Ex01 ex01 = new Ex01();
        System.out.println(ex01);
    }
}
/**输出：
 * Ex01()
 * Simple()
 * Ex01{simple=Simple() is Constructed}
 */