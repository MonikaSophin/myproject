package com.thinkinginjava.inner_classes.exercise.chapter10_4;

/**
 * @Author: monika
 * @Date: 2018/12/4 22:44
 * @Version: 1.0
 * @Description: page 195
 * 练习08：确定外部类是否可以访问内部类的private元素。（可以）
 */
public class Ex08 {
    class InnerClazz1{
        private int i = 10;
        private void sayHi(){ System.out.println("InnerClazz1#sayHi()"); }
    }

    void sayHi(){
        InnerClazz1 innerClazz1 = this.new InnerClazz1();
        innerClazz1.sayHi();
    }

    public static void main(String[] args) {
        Ex08 ex08 = new Ex08();
        ex08.sayHi();
    }
}
/**输出：
 * InnerClazz1#sayHi()
 */
