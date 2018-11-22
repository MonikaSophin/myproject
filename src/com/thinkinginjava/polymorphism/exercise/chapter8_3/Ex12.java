package com.thinkinginjava.polymorphism.exercise.chapter8_3;

/**
 * @Author: monika
 * @Date: 2018/11/21 21:45
 * @Version: 1.0
 * @Description: page 161
 * 练习12：修改练习9.使其能够演示基类和导出类的初始化顺序。然后向基类和导出类
 * 中添加成员对象，并说明构建期间初始化发生的顺序。
 */
class Characteristic {
    private String s;
    Characteristic(String s) {
        this.s = s;
        System.out.println("Creating Characteristic " + s);
    }
}

class Description {
    private String s;
    Description(String s) {
        this.s = s;
        System.out.println("Creating Description " + s);
    }
}

class Rodent{
    private Characteristic c = new Characteristic("Rodent");
    private Description d = new Description("Rodent");
    public Rodent() {
        System.out.println("Creating Rodent");
    }
    void bite(){ System.out.println("Rodent bite()"); }
    @Override
    public String toString() { return "Rodent{}"; }
}

class Mouse extends Rodent{
    private Characteristic c = new Characteristic("Mouse");
    private Description d = new Description("Mouse");
    public Mouse() {
        System.out.println("Creating Mouse");
    }
    @Override
    void bite() { System.out.println("Mouse bite()"); }
    @Override
    public String toString() { return "Mouse{}"; }
}

class Gerbil extends Rodent{
    private Characteristic c = new Characteristic("Gerbil");
    private Description d = new Description("Gerbil");
    public Gerbil() {
        System.out.println("Creating Gerbil");
    }
    @Override
    void bite() { System.out.println("Gerbil bite()"); }
    @Override
    public String toString() { return "Gerbil{}"; }
}

class Hamster extends Rodent{
    private Characteristic c = new Characteristic("Hamster");
    private Description d = new Description("Hamster");
    public Hamster() {
        System.out.println("Creating Hamster");
    }
    @Override
    void bite() { System.out.println("Hamster bite()"); }
    @Override
    public String toString() { return "Hamster{}"; }
}

public class Ex12 {
    public static void main(String[] args) {
        Rodent[] rodents = {
                new Mouse(),
                new Gerbil(),
                new Hamster()
        };
        for (int i = 0; i < rodents.length ; i++) {
            rodents[i].bite();
        }
    }
}
/**输出：
 * Creating Characteristic Rodent
 * Creating Description Rodent
 * Creating Rodent
 * Creating Characteristic Mouse
 * Creating Description Mouse
 * Creating Mouse
 * Creating Characteristic Rodent
 * Creating Description Rodent
 * Creating Rodent
 * Creating Characteristic Gerbil
 * Creating Description Gerbil
 * Creating Gerbil
 * Creating Characteristic Rodent
 * Creating Description Rodent
 * Creating Rodent
 * Creating Characteristic Hamster
 * Creating Description Hamster
 * Creating Hamster
 * Mouse bite()
 * Gerbil bite()
 * Hamster bite()
 */