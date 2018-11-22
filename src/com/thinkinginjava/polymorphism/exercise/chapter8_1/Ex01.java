package com.thinkinginjava.polymorphism.exercise.chapter8_1;

/**
 * @Author: monika
 * @Date: 2018/11/19 21:00
 * @Version: 1.0
 * @Description: page 150
 * 练习01：创建一个Cycle类，它具有子类Unicycle,Bicycle和Tricycle。演示每一个类型的
 * 实例都可以经由ride()方法向上转型为Cycle。
 */
class Cycle{
    void ride(Cycle cycle){
        System.out.println(cycle +" ride");
    }
    @Override
    public String toString() {
        return "Cycle{}";
    }
}
class Unicycle extends Cycle{
    @Override
    public String toString() {
        return "Unicycle{}";
    }
}
class Bicycle extends Cycle{
    @Override
    public String toString() {
        return "Bicycle{}";
    }
}
class Tricycle extends Cycle{
    @Override
    public String toString() {
        return "Tricycle{}";
    }
}

public class Ex01 {
    static void ride(Cycle cycle){
        cycle.ride(cycle);
    }
    public static void main(String[] args) {
        Cycle cycle = new Cycle();
        Unicycle unicycle = new Unicycle();
        Bicycle bicycle = new Bicycle();
        Tricycle tricycle = new Tricycle();

        ride(cycle);
        ride(unicycle);
        ride(bicycle);
        ride(tricycle);
    }
}
/**输出：
 * Cycle{} ride
 * Unicycle{} ride
 * Bicycle{} ride
 * Tricycle{} ride
 */