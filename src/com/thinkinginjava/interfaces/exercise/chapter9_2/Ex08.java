package com.thinkinginjava.interfaces.exercise.chapter9_2;

/**
 * @Author: monika
 * @Date: 2018/11/25 10:30
 * @Version: 1.0
 * @Description: page 174
 * 练习08：在polymorephism.Sandwich.java中，创建接口FastFood并添加合适的方法，
 * 然后修改Sandwich以实现FastFood接口。
 */
interface FastFood{
    void food();
}

class Meal implements FastFood{
    public void food() { System.out.println("Meal#food()"); }
}

class Bread implements FastFood{
    public void food() { System.out.println("Bread#food()"); }
}

class Cheese implements FastFood{
    public void food() { System.out.println("Cheese#food()"); }
}

class Lettuce implements FastFood{
    public void food() { System.out.println("Lettuce#food()"); }
}

class Lunch extends Meal implements FastFood{
    public void food() { System.out.println("Lunch#food()"); }
}

class PortableLunch extends Lunch implements FastFood {
    public void food() { System.out.println("PortableLunch#food()"); }
}

class Sandwich extends PortableLunch implements FastFood{
    public void food() { System.out.println("Sandwich#food()"); }
}

public class Ex08 {
    public static void main(String[] args) {
        FastFood[] fastFoods = {new Meal(), new Bread(),
                new Cheese(),new Lettuce(),new Lunch(),
                new PortableLunch(),new Sandwich()};
        for (FastFood fastFood : fastFoods){
            fastFood.food();
        }
    }
}
/**输出：
 * Meal#food()
 * Bread#food()
 * Cheese#food()
 * Lettuce#food()
 * Lunch#food()
 * PortableLunch#food()
 * Sandwich#food()
 */