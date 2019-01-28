package com.thinkinginjava.type_information.example.chapter14_2.ex14_2_2;

/**
 * @Author: monika
 * @Date: 2019/1/26 16:48
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

public class GenericToyTest {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        Class<FancyToy> ftClass = FancyToy.class;
        FancyToy fancyToy = ftClass.newInstance();

        Class<? super FancyToy> up = ftClass.getSuperclass();
        //! Class<Toy> up2 = ftClass.getSuperclass();
        Object obj = up.newInstance();
    }
}
