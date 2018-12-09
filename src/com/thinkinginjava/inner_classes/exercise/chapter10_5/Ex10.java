package com.thinkinginjava.inner_classes.exercise.chapter10_5;

/**
 * @Author: monika
 * @Date: 2018/12/5 17:42
 * @Version: 1.0
 * @Description: page 196
 * 练习10;重复前一个练习，但将内部类定义在某个方法的一个作用域内。
 */
public class Ex10 {
    private void get10(boolean b){
        if (b){
            class Clazz10 implements Interface9{
                @Override
                public void method9() { System.out.println("Ex10#get10()"); }
            }
            Clazz10 clazz10 = new Clazz10();
            clazz10.method9();
        }
    }

    public void get(){get10(true);};
    public static void main(String[] args) {
        Ex10 ex10 = new Ex10();
        ex10.get();
    }
}
/**输出：
 * Ex10#get()
 */