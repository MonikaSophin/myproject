package com.thinkinginjava.inner_classes.exercise.chapter10_4;

/**
 * @Author: monika
 * @Date: 2018/12/4 22:35
 * @Version: 1.0
 * @Description: page 195
 * 练习07：创建一个含有private域和private方法的类。创建一个内部类，它有一个方法可
 * 用来修改外围类的域，并调用外围类的方法。在外围类的另一方法中，创建此内部类的对象，
 * 并且调用它的方法，然后说明对外围类对象的影响。
 */
public class Ex07 {
    private int i = 10;
    private void print(int i){ System.out.println("Ex07#print() -- " + i); }

    class InnerClazz1{
        void update(){
            i = 11;
            print(i);
        }
    }

    InnerClazz1 getInnerClazz1(){
       return this.new InnerClazz1();
    }

    public static void main(String[] args) {
        Ex07 ex07 = new Ex07();
        ex07.print(1);

        InnerClazz1 innerClazz1 = ex07.getInnerClazz1();
        innerClazz1.update();
    }
}
/**输出：
 * Ex07#print() -- 1
 * Ex07#print() -- 11
 */