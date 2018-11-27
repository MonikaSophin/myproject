package com.thinkinginjava.interfaces.exercise.chapter9_9;

/**
 * @Author: monika
 * @Date: 2018/11/27 21:49
 * @Version: 1.0
 * @Description: page 188
 * 练习18：创建一个Cycle接口以及Unicycle、Bicycle和Tricycle实现。对每种类型的Cycle
 * 都创建相应的工厂，然后编写使用这些工厂。
 */
interface Cycle{
    void ride();
}

class Unicycle implements Cycle{
    @Override
    public void ride() { System.out.println("Unicycle#ride()"); }
}

class Bicycle implements Cycle{
    @Override
    public void ride() { System.out.println("Bicycle#ride()"); }
}

class Tricycle implements Cycle{
    @Override
    public void ride() { System.out.println("Tricycle#ride()"); }
}

interface CycleFactory{
    Cycle getCycle();
}

class UnicycleFactory implements CycleFactory{
    @Override
    public Cycle getCycle() { return new Unicycle(); }
}

class BicycleFactory implements CycleFactory{
    @Override
    public Cycle getCycle() { return new Bicycle(); }
}

class TricycleFactory implements CycleFactory{
    @Override
    public Cycle getCycle() { return new Tricycle(); }
}

public class Ex18 {
    public static void test(CycleFactory cycleFactory){
        Cycle cycle = cycleFactory.getCycle();
        cycle.ride();
    }

    public static void main(String[] args) {
        test(new UnicycleFactory());
        test(new BicycleFactory());
        test(new TricycleFactory());
    }
}
/**输出：
 * Unicycle#ride()
 * Bicycle#ride()
 * Tricycle#ride()
 */