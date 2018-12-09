package com.thinkinginjava.inner_classes.exercise.chapter10_6;

/**
 * @Author: monika
 * @Date: 2018/12/6 22:19
 * @Version: 1.0
 * @Description: page 199
 * 练习13：重复练习9，这次使用匿名内部类。
 */
interface Interface13{
    void method13();
}

public class Ex13 {
    Interface13 getInterface13(){
       return () -> System.out.println("Ex13#getInterface13()");
    }

    public static void main(String[] args) {
        Ex13 ex13 = new Ex13();
        Interface13 interface13 = ex13.getInterface13();
        interface13.method13();
    }
}
/**输出：
 * Ex13#getInterface13()
 */