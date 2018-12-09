package com.thinkinginjava.inner_classes.exercise.chapter10_5;

/**
 * @Author: monika
 * @Date: 2018/12/5 17:35
 * @Version: 1.0
 * @Description: page 196
 * 练习09：创建一个至少有一个方法的接口。在某个方法内定义一个内部类以实现此接口，
 * 这个方法返回对此接口的引用。
 */
interface Interface9{
    void method9();
}

public class Ex09 {
    Interface9 getInterface9(){
        class Clazz9 implements Interface9{
            @Override
            public void method9() { System.out.println("Ex09#getInterface9()"); }
        }
        return new Clazz9();
    }

    public static void main(String[] args) {
        Ex09 ex09 = new Ex09();
        Interface9 interface9 = ex09.getInterface9();
        interface9.method9();
    }
}
/**输出：
 * Ex09#getInterface9()
 */