package com.thinkinginjava.inner_classes.exercise.chapter10_6;

/**
 * @Author: monika
 * @Date: 2018/12/6 22:29
 * @Version: 1.0
 * @Description: page 199
 * 练习15：创建一个类，它有非默认的构造器（即需要参数的构造器），并且没有默认构造
 * 器（没有无参数的构造器）。创建第二个类，它包含一个方法，能够返回对第一个类的对
 * 象的引用。通过写一个继承自第一个类的匿名内部类，来创建一个返回对象。
 */
class Clazz15{
    private String s;
    public Clazz15(String s) {
        this.s = s;
        System.out.println("Clazz15 construct " + s);
    }
    void get(){ System.out.println("Clazz15#get() " + s); }
}

public class Ex15 {
    Clazz15 getClazz15(String s){
        return new Clazz15(s){
            @Override
            public void get(){ System.out.println("Ex15#getClazz15() " + s); }
        };
    }

    public static void main(String[] args) {
        Ex15 ex15 = new Ex15();
        Clazz15 clazz15 = ex15.getClazz15("test");
        clazz15.get();
    }
}
/**输出：
 * Clazz15 construct test
 * Ex15#getClazz15() test
 */