package com.thinkinginjava.generics.example.chapter15_13;

import com.thinkinginjava.type_information.example.chapter14_3.pets.Cat;
import com.thinkinginjava.type_information.example.chapter14_3.pets.Dog;
import com.thinkinginjava.type_information.example.chapter14_3.pets.Pet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author: monika
 * @Date: 2019/2/17 21:29
 * @Version: 1.0
 * @Description:
 */
public class CheckedList {
    //未加入泛型 会出现警告
    @SuppressWarnings("unchecked")
    static void oldStyleMethod(List probablyDogs) {
        probablyDogs.add(new Cat());
    }

    public static void main(String[] args) {
        List<Dog> dogs1 = new ArrayList<>();
        oldStyleMethod(dogs1); //接受了一个Cat

        List<Dog> dogs2 = Collections.checkedList(
                new ArrayList<>(), Dog.class);
        try {
            oldStyleMethod(dogs2);
        }catch (Exception e) {
            System.out.println(e);
        }

        List<Pet> pets = Collections.checkedList(
                new ArrayList<>(), Pet.class);
        pets.add(new Dog());
        pets.add(new Cat());
    }
}
/**output:
 * java.lang.ClassCastException: Attempt to insert class
 *  com.thinkinginjava.type_information.example.chapter14_3.pets.Cat
 *  element into collection with element type class
 *  com.thinkinginjava.type_information.example.chapter14_3.pets.Dog
 */