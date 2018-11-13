package com.thinkinginjava.access_control.exercise.chapter6_2;

/**
 * @Author: monika
 * @Date: 2018/11/13 22:01
 * @Version: 1.0
 * @Description: page 120
 * 练习06：创建一个带有protected数据的类。运用在第一个类中处理protected数据的方法
 * 在相同的文件中创建第二个类。
 */
class SomeData {
    protected int a = 13;
}

class DataChanger {
    static void change(SomeData sd, int i) {
        sd.a = i;
    }
}

public class Ex06 {
    public static void main(String[] args) {
        SomeData x = new SomeData();
        System.out.println(x.a);
        DataChanger.change(x, 99);
        System.out.println(x.a);
    }
}
/**输出：
 * 13
 * 99
 */