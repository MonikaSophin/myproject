package com.thinkinginjava.inner_classes.exercise.chapter10_6;

/**
 * @Author: monika
 * @Date: 2018/12/7 22:58
 * @Version: 1.0
 * @Description: page 201
 * 练习16：修改第9章中练习18的解决方案，让它使用匿名内部类。
 */
interface Cycle{ void ride(); }
interface CycleFactory{ Cycle getCycle(); }

class Unicycle implements Cycle{
    private Unicycle(){}
    @Override
    public void ride() { System.out.println("Unicycle#ride()"); }
    public static CycleFactory factory = new CycleFactory() {
                @Override
                public Cycle getCycle() { return new Unicycle(); }
            };
}

class Bicycle implements Cycle{
    private Bicycle(){}
    @Override
    public void ride() { System.out.println("Bicycle#ride()"); }
    public static CycleFactory factory =
            () -> new Bicycle();
}

class Tricycle implements Cycle{
    private Tricycle(){}
    @Override
    public void ride() { System.out.println("Tricycle#ride()"); }
    public static CycleFactory factory =
            () -> { Cycle tricycle = new Tricycle();
                return tricycle; };
}


public class Ex16 {
    private static void cycleConsumer(CycleFactory factory){
        Cycle cycle = factory.getCycle();
        cycle.ride();
    }

    public static void main(String[] args) {
        cycleConsumer(Unicycle.factory);
        cycleConsumer(Bicycle.factory);
        cycleConsumer(Tricycle.factory);
    }
}
/**输出：
 * Unicycle#ride()
 * Bicycle#ride()
 * Tricycle#ride()
 */