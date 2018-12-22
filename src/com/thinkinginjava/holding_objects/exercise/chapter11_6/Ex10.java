package com.thinkinginjava.holding_objects.exercise.chapter11_6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @Author: monika
 * @Date: 2018/12/15 15:28
 * @Version: 1.0
 * @Description: page 227
 * 练习10：修改第8章中的练习9，使其使用一个ArrayList来存放Rodents，并使用一个
 * Iterator来访问Rodent序列。
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

class Gerbill extends Rodent{
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

public class Ex10 {
    public static void main(String[] args) {
        List<Rodent> lists = new ArrayList<>();
        Rodent[] rodents = {
                new Mouse(),
                new Gerbill(),
                new Hamster()
        };
        lists.addAll(Arrays.asList(rodents));

        Iterator<Rodent> iterator = lists.iterator();
        while (iterator.hasNext()){
            Rodent next = iterator.next();
            System.out.println(next);
            next.bite();
        }
    }
}
/**输出：
 * Mouse{}
 * Mouse bite()
 * Gerbil{}
 * Gerbil bite()
 * Hamster{}
 * Hamster bite()
 */