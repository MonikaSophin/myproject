package com.thinkinginjava.polymorphism.exercise.chapter8_2;

/**
 * @Author: monika
 * @Date: 2018/11/19 21:36
 * @Version: 1.0
 * @Description: page 153
 * 练习05：以练习1为基础，在Cycle中添加wheels()方法，它将返回轮子的数量。修改ride()
 * 方法，让它调用wheels()方法，并验证多态起作用了。
 */
class Cycle{
    void ride(Cycle cycle){
        System.out.print(cycle +" ride");
        System.out.println("----Cycle.wheels " + wheels());
    }
    int wheels(){ return 0; }
    @Override
    public String toString() {
        return "Cycle{}";
    }
}
class Unicycle extends Cycle{
    int wheels(){ return 1; }
    @Override
    public String toString() {
        return "Unicycle{}";
    }
}
class Bicycle extends Cycle{
    int wheels(){ return 2; }
    @Override
    public String toString() {
        return "Bicycle{}";
    }
}
class Tricycle extends Cycle{
    int wheels(){ return 3; }
    @Override
    public String toString() {
        return "Tricycle{}";
    }
}

public class Ex05 {
    static void ride(Cycle cycle){
        cycle.ride(cycle);
    }
    public static void main(String[] args) {
        Unicycle unicycle = new Unicycle();
        Bicycle bicycle = new Bicycle();
        Tricycle tricycle = new Tricycle();
        Cycle cycle = new Cycle();

        ride(cycle);
        ride(unicycle);
        ride(bicycle);
        ride(tricycle);
    }
}
/**输出：
 * Cycle{} ride----Cycle.wheels 0
 * Unicycle{} ride----Cycle.wheels 1
 * Bicycle{} ride----Cycle.wheels 2
 * Tricycle{} ride----Cycle.wheels 3
 */