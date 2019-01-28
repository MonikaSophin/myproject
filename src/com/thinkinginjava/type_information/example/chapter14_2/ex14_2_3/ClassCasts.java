package com.thinkinginjava.type_information.example.chapter14_2.ex14_2_3;

/**
 * @Author: monika
 * @Date: 2019/1/26 16:53
 * @Version: 1.0
 * @Description:
 */
class Building {}
class House extends Building {}

public class ClassCasts {
    public static void main(String[] args) {
        Building b = new House();
        Class<House> houseType = House.class;
        House h = houseType.cast(b);
        h = (House) b;
    }
}
