package com.thinkinginjava.type_information.example.chapter14_2;

/**
 * @Author: monika
 * @Date: 2019/1/16 23:02
 * @Version: 1.0
 * @Description:
 */
interface HasBatteries {}
interface Waterproof {}
interface Shoots {}

class Toy {
    public Toy() {}
    public Toy(int i) {}
}

class FancyToy extends Toy implements HasBatteries, Waterproof, Shoots{
    public FancyToy() { super(1); }
}

public class ToyTest {
    static void printInfo(Class cc) {
        System.out.println("Class name: " + cc.getName() +
                " is interface? [" + cc.isInterface() + "]");
        System.out.println("Simple name: " + cc.getSimpleName());
        System.out.println("Canonical name: " + cc.getCanonicalName());
    }

    public static void main(String[] args) {
        Class c = null;
        try {
            c = Class.forName("com.thinkinginjava.type_information.example.chapter14_2.FancyToy");
        } catch (ClassNotFoundException e) {
            System.out.println("Can't find FancyToy");
            System.exit(1);
        }
        printInfo(c);
        System.out.println();

        for (Class face : c.getInterfaces())
            printInfo(face);
        System.out.println();

        Class up = c.getSuperclass();
        Object obj = null;
        try {
            //使用Class#newInstance()来创建Object引用（此引用指向的是Toy对象），必须含有默认的无参构造器。
            obj = up.newInstance();
        } catch (InstantiationException e) {
            System.out.println("Cannot instantiate");
            System.exit(1);
        } catch (IllegalAccessException e) {
            System.out.println("Cannot access");
            System.exit(1);
        }
        printInfo(obj.getClass());
    }
}
/**output:
 * Class name: com.thinkinginjava.type_information.example.chapter14_2.FancyToy is interface? [false]
 * Simple name: FancyToy
 * Canonical name: com.thinkinginjava.type_information.example.chapter14_2.FancyToy
 *
 * Class name: com.thinkinginjava.type_information.example.chapter14_2.HasBatteries is interface? [true]
 * Simple name: HasBatteries
 * Canonical name: com.thinkinginjava.type_information.example.chapter14_2.HasBatteries
 * Class name: com.thinkinginjava.type_information.example.chapter14_2.Waterproof is interface? [true]
 * Simple name: Waterproof
 * Canonical name: com.thinkinginjava.type_information.example.chapter14_2.Waterproof
 * Class name: com.thinkinginjava.type_information.example.chapter14_2.Shoots is interface? [true]
 * Simple name: Shoots
 * Canonical name: com.thinkinginjava.type_information.example.chapter14_2.Shoots
 *
 * Class name: com.thinkinginjava.type_information.example.chapter14_2.Toy is interface? [false]
 * Simple name: Toy
 * Canonical name: com.thinkinginjava.type_information.example.chapter14_2.Toy
 */