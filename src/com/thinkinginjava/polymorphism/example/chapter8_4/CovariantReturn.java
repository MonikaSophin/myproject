package com.thinkinginjava.polymorphism.example.chapter8_4;

/**
 * @Author: monika
 * @Date: 2018/11/22 21:41
 * @Version: 1.0
 * @Description:  java se5中添加了协变返回类型，它表示在导出类中的
 *               被覆盖方法可以返回基类方法返回类型的某种导出类型。
 *
 *               java重写 ：方法签名(方法名、参数列表)相同。
 *                         返回值类型为基类方法返回值类型的子类或者是其本身。
 *                         访问修饰符权限不能严于基类和所抛出异常不能小于基类。
 */
class Grain {
    public String toString() { return "Grain"; }
}

class Wheat extends Grain {
    public String toString() { return "Wheat"; }
}

class Mill {
    Grain process() { return new Grain(); }
}

class WheatMill extends Mill {
   @Override Wheat process() { return new Wheat(); }
}

public class CovariantReturn {
    public static void main(String[] args) {
        Mill m = new Mill();
        Grain g = m.process();
        System.out.println(g);
        m = new WheatMill();
        g = m.process();
        System.out.println(g);
    }
}
