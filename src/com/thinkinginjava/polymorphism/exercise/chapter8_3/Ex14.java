package com.thinkinginjava.polymorphism.exercise.chapter8_3;

/**
 * @Author: monika
 * @Date: 2018/11/21 22:08
 * @Version: 1.0
 * @Description: page 162
 * 练习14：修改练习12.使得其某个成员对象变为具有引用计数的共享对象，并证明它可以正确运行。
 */
class Characteristic14 {
    private String s;
    private int refCount = 0;
    private static int count = 0;
    private final int id = count++;
    Characteristic14(String s) {
        this.s = s;
        System.out.println("Creating Characteristic14 " + s);
    }
    public void addRef(){
        refCount++;
    }
    @Override
    public String toString() {
        return "Characteristic14[" + id +"]";
    }

}

class Description14 {
    private String s;
    Description14(String s) {
        this.s = s;
        System.out.println("Creating Description14 " + s);
    }
}

class Rodent14{
    private Characteristic14 c ;
    private Description14 d = new Description14("Rodent14");
    public Rodent14(Characteristic14 c) {
        System.out.println("Creating Rodent14");
        this.c = c;
        this.c.addRef();
    }
    void bite(){ System.out.println("Rodent14 bite() -- " + c); }
}

class Mouse14 extends Rodent14{
    private Characteristic14 c;
    private Description14 d = new Description14("Mouse14");
    public Mouse14(Characteristic14 c) {
        super(c);
        System.out.println("Creating Mouse14");
        this.c = c;
        this.c.addRef();
    }
    @Override
    void bite() { System.out.println("Mouse14 bite() -- " + c); }
}

class Gerbil14 extends Rodent14{
    private Characteristic14 c;
    private Description14 d = new Description14("Gerbil14");
    public Gerbil14(Characteristic14 c) {
        super(c);
        System.out.println("Creating Gerbil14");
        this.c = c;
        this.c.addRef();

    }
    @Override
    void bite() { System.out.println("Gerbil14 bite() -- " + c); }
}

class Hamster14 extends Rodent14{
    private Characteristic14 c;
    private Description14 d = new Description14("Hamster14");
    public Hamster14(Characteristic14 c) {
        super(c);
        System.out.println("Creating Hamster14");
        this.c = c;
        this.c.addRef();
    }
    @Override
    void bite() { System.out.println("Hamster14 bite() -- " + c); }
}

public class Ex14 {
    public static void main(String[] args) {
        Characteristic14 c1 = new Characteristic14("ref1");
        Characteristic14 c2 = new Characteristic14("ref2");
        Characteristic14 c3 = new Characteristic14("ref3");
        Rodent14[] rodents = {
                new Mouse14(c1),
                new Gerbil14(c2),
                new Hamster14(c3)
        };
        for (int i = 0; i < rodents.length ; i++) {
            rodents[i].bite();
        }
    }
}
