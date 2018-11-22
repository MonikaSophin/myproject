package com.thinkinginjava.polymorphism.exercise.chapter8_2;

/**
 * @Author: monika
 * @Date: 2018/11/20 21:53
 * @Version: 1.0
 * @Description: page 155
 * 练习09：创建Rodent(啮齿动物)：Mouse(老鼠)，Gerbil(鼹鼠)，Hamster(大颊鼠)，
 * 等等这样一个的继承层次结构。在基类中，提供对所有的Rodent都通用的方法，在导出类中，
 * 根据特定的Rodent类型覆盖这些方法，以便它们执行不同的行为。创建一个Rodent数组，
 * 填充不同的Rodent类型，然后调用基类方法，观察发生什么情况。
 */
class Rodent{
    void bite(){ System.out.println("Rodent bite()"); }
    @Override
    public String toString() { return "Rodent{}"; }
}

class Mouse extends Rodent{
    @Override
    void bite() { System.out.println("Mouse bite()"); }
    @Override
    public String toString() { return "Mouse{}"; }
}

class Gerbil extends Rodent{
    @Override
    void bite() { System.out.println("Gerbil bite()"); }
    @Override
    public String toString() { return "Gerbil{}"; }
}

class Hamster extends Rodent{
    @Override
    void bite() { System.out.println("Hamster bite()"); }
    @Override
    public String toString() { return "Hamster{}"; }
}

public class Ex09 {
    public static void main(String[] args) {
        Rodent[] rodents = {
                new Mouse(),
                new Gerbil(),
                new Hamster()
        };
        for (int i = 0; i < rodents.length ; i++) {
            rodents[i].bite();
            System.out.println(rodents[i]);
        }
    }
}
/**输出：
 * Mouse bite()
 * Mouse{}
 * Gerbil bite()
 * Gerbil{}
 * Hamster bite()
 * Hamster{}
 */