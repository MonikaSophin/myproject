package com.thinkinginjava.Initialize_clean.exercise.chapter5_3;

/**
 * @Author: monika
 * @Date: 2018/11/9 22:21
 * @Version: 1.0
 * @Description: page 83
 * 练习05：创建一个名为Dog的类，它具有重载的bark()方法。此方法应根据不同的基本数
 * 据类型进行重载，并根据被调用的版本，打印出不同的类型的狗吠(barking)、咆哮(howling)
 * 等信息。编写main()来调用所有不同版本的方法。
 */
class Dog1{
    public void barking(int x){
        System.out.println("barking:int "+x);
    }
    public void barking(double x){
        System.out.println("barking:double "+x);
    }
    public void barking(float x){
        System.out.println("barking:float "+x);
    }
    public void barking(char x){
        System.out.println("barking:char ");
    }
    public void barking(long x){
        System.out.println("barking:long "+x);
    }
    public void barking(byte x){
        System.out.println("barking:byte "+x);
    }

}
public class Ex05 {
    public static void main(String[] args) {
        Dog1 dog = new Dog1();
        double x = 0;
        dog.barking(x);
        dog.barking((int) x);
        dog.barking((float) x);
        dog.barking((char) x);

        short y = 1;
        dog.barking(y);
        dog.barking((byte) y);
        dog.barking((long) y);
    }
}
/**输出：
 * barking:double 0.0
 * barking:int 0
 * barking:float 0.0
 * barking:char
 * barking:int 1
 * barking:byte 1
 * barking:long 1
 */