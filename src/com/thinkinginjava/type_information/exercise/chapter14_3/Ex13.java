package com.thinkinginjava.type_information.exercise.chapter14_3;

import com.thinkinginjava.type_information.example.chapter14_3.ex14_3_3.TypeCounter;

/**
 * @Author: monika
 * @Date: 2019/1/26 18:38
 * @Version: 1.0
 * @Description: page 331
 * Ex13:将本章中的RegisteredFactories.java示例用于TypeCounter.
 */
public class Ex13 {
    private static Part[] createArray(int size) {
        Part[] parts = new Part[size];
        for (int i = 0; i < size; i++)
            parts[i] = Part.createRandom();
        return parts;
    }
    public static void main(String[] args) {
        TypeCounter counter = new TypeCounter(Part.class);
        for (Part type : createArray(10)) {
            System.out.print(type.getClass().getSimpleName() + " ");
            counter.count(type);
        }
        System.out.println();
        System.out.println(counter);
    }
}
/**output:
 * GeneratorBelt CabinAirFilter GeneratorBelt AirFilter PowerSteeringBelt CabinAirFilter FuelFilter PowerSteeringBelt PowerSteeringBelt FuelFilter
 * {GeneratorBelt=2, Part=10, AirFilter=1, FuelFilter=2, Filter=5, PowerSteeringBelt=3, Belt=5, CabinAirFilter=2}
 */