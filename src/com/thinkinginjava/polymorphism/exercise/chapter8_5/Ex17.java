package com.thinkinginjava.polymorphism.exercise.chapter8_5;

/**
 * @Author: monika
 * @Date: 2018/11/22 22:15
 * @Version: 1.0
 * @Description:  page 168
 * 练习17：使用练习1中的Cycle的层次结构，在Unicycle和Bicycle中添加balance()方法，
 * 而Tricycle中不添加。创建所有这三种类型的实例，并将它们向上转型为Cycle数组。在该数组
 * 的每个元素上都尝试调用balance()，并观察结果。然后将它们向下转型，再次调用balance(),
 * 并观察将所产生什么。
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
    public void balance(){ System.out.println("Unicycle#balance()"); }
}
class Bicycle extends Cycle{
    @Override
    public String toString() {
        return "Bicycle{}";
    }
    public void balance(){ System.out.println("Bicycle#balance()"); }
}
class Tricycle extends Cycle{
    @Override
    public String toString() {
        return "Tricycle{}";
    }
}

public class Ex17 {
    public static void main(String[] args) {
        Cycle[] cycles  = {new Unicycle(),new Bicycle(),new Tricycle()};
        for (Cycle cycle: cycles) {
            // Compile time error: cannot find balance() method in Cycle:
           //! cycle.balance();
        }
        ((Unicycle)cycles[0]).balance();
        ((Bicycle)cycles[1]).balance();
        // Compile time error: no balance() in Tricycle:
        //! ((Tricycle)cycles[2]).balance();
        // RTTI: ClassCastException: Tricycle cannot be cast to Bicycle:
        //! ((Unicycle)cycles[2]).balance();
        //! ((Bicycle)cycles[2]).balance();
    }
}
/**输出：
 * Unicycle#balance()
 * Bicycle#balance()
 */