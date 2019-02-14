package com.thinkinginjava.generics.example.chapter15_10.ex15_10_2;

import com.thinkinginjava.generics.example.chapter15_10.model.Apple;
import com.thinkinginjava.generics.example.chapter15_10.model.Fruit;
import com.thinkinginjava.type_information.example.chapter14_9.A;

import java.util.Arrays;
import java.util.List;

/**
 * @author: XueYing.Cao
 * @date: 2019/2/14
 * @description:
 */
public class GenericReading {
    static List<Apple> apples = Arrays.asList(new Apple());
    static List<Fruit> fruit = Arrays.asList(new Fruit());

    // 读取和写入 不变
    static <T> T readExact(List<T> lsit) {
        return lsit.get(0);
    }
    // 如果您有一个类，则在实例化类时建立其类型:
    static class Reader<T> {
        T readExact(List<T> list) {
            return list.get(0);
        }
    }
    //协变 （对只读类型的容器有效）
    static class CovariantReader<T> {
        T readCovariant(List<? extends T> list) {
            return list.get(0);
        }
    }

    static void f1() {
        Apple a = readExact(apples);
        Fruit f = readExact(fruit);
        f = readExact(apples);
    }
    static void f2() {
        Reader<Fruit> fruitReader = new Reader<>();
        Fruit f = fruitReader.readExact(fruit);
        //  readExact（List <Fruit>）方法不能应用于（List <Apple>）.
        //! Fruit a = fruitReader.readExact(apples);

        Reader<Apple> appleReader = new Reader<>();
        appleReader.readExact(apples);
        //  readExact（List <Apple>）方法不能应用于（List <Fruit>）.
        //! appleReader.readExact(fruit);
    }
    static void f3() {
        CovariantReader<Fruit> fruitReader = new CovariantReader<>();
        Fruit f = fruitReader.readCovariant(fruit);
        Fruit a = fruitReader.readCovariant(apples);
    }

    public static void main(String[] args) {
        f1(); f2(); f3();
    }
}
//~