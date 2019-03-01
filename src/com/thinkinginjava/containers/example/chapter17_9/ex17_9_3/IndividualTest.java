package com.thinkinginjava.containers.example.chapter17_9.ex17_9_3;

import com.thinkinginjava.holding_objects.example.chapter11_10.MapOfList;
import com.thinkinginjava.util.pets.Individual;
import com.thinkinginjava.util.pets.Pet;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author: XueYing.Cao
 * @date: 2019/3/1
 * @description:
 */
public class IndividualTest {
    public static void main(String[] args) {
        Set<Individual> pets = new TreeSet<>();
        for (List<? extends Pet> lp : MapOfList.petPeople.values()) {
            for (Pet p : lp)
                pets.add(p);
        }

        System.out.println(pets);
    }
}
/**output:
 * [Cat Elsie May, Cat Pinkola, Cat Shackleton, Cat Stanford aka Stinky el Negro, Cymric Molly, Dog Margrett, Mutt Spot, Pug Louie aka Louis Snorkelstein Dupree, Rat Fizzy, Rat Freckly, Rat Fuzzy]
 */