package com.thinkinginjava.generics.example.chapter15_4.ex15_4_1;

import com.thinkinginjava.type_information.example.chapter14_3.pets.Person;
import com.thinkinginjava.type_information.example.chapter14_3.pets.Pet;
import java.util.List;
import java.util.Map;

/**
 * @Author: monika
 * @Date: 2019/2/3 20:11
 * @Version: 1.0
 * @Description:
 */
public class SimplerPets {
    public static void main(String[] args) {
        Map<Person, List<? extends Pet>> petPeople = New.map();
    }
}
