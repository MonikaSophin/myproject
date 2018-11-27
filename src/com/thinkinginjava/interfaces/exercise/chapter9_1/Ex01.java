package com.thinkinginjava.interfaces.exercise.chapter9_1;

/**
 * @Author: monika
 * @Date: 2018/11/23 21:17
 * @Version: 1.0
 * @Description: page 171
 * 练习01：修改第8章练习9中的Rodent,使其成为一个抽象类。只要有可能，就将
 * Rodent的方法声明为抽象方法。
 */
abstract class Rodent{
    abstract void bite();
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

public class Ex01 {
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