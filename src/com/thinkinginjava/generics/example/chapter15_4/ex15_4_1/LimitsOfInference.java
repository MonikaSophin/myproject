package com.thinkinginjava.generics.example.chapter15_4.ex15_4_1;

import com.thinkinginjava.util.pets.Person;
import com.thinkinginjava.util.pets.Pet;
import com.thinkinginjava.util.New;
import java.util.List;
import java.util.Map;

/**
 * @Author: monika
 * @Date: 2019/2/3 20:13
 * @Version: 1.0
 * @Description:
 */
public class LimitsOfInference {
    static void f(Map<Person, List<? extends Pet>> petPeople) {}

    public static void main(String[] args) {
        f(New.map());
    }
 }
