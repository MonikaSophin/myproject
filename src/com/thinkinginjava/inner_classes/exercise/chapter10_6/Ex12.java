package com.thinkinginjava.inner_classes.exercise.chapter10_6;

/**
 * @Author: monika
 * @Date: 2018/12/6 22:01
 * @Version: 1.0
 * @Description: page 199
 * 练习12：重复练习7，这次使用匿名内部类。
 */
interface InnerClazz12{
    void update();
}

public class Ex12 {
    /*InnerClazz12 getInnerClazz12(){
        return new InnerClazz12(){
            @Override
            public void update(){ System.out.println("EX12#getInnerClazz12()"); }
        };
    }*/

    //Lambda表达式
    InnerClazz12 getInnerClazz12(){
       return  () -> System.out.println("EX12#getInnerClazz12()");
    }

    public static void main(String[] args) {
        Ex12 ex12 = new Ex12();
        InnerClazz12 innerClazz12 = ex12.getInnerClazz12();
        innerClazz12.update();
    }
}
/**输出：
 * EX12#getInnerClazz12()
 */