package com.thinkinginjava.type_information.example.chapter14_3.ex14_3_3;

import com.thinkinginjava.type_information.example.chapter14_3.ex14_3_1.Pets;
import com.thinkinginjava.type_information.example.chapter14_3.pets.Pet;

/**
 * @Author: monika
 * @Date: 2019/1/26 18:11
 * @Version: 1.0
 * @Description:
 */
public class PetCount4 {
    public static void main(String[] args) {
        TypeCounter counter = new TypeCounter(Pet.class);
        for (Pet pet : Pets.createArray(20)) {
            System.out.print(pet.getClass().getSimpleName() +" ");
            counter.count(pet);
        }
        System.out.println();
        System.out.println(counter);
    }
}
/**output:
 * Rat Manx Cymric Mutt Pug Cymric Pug Manx Cymric Rat EgyptianMau Hamster EgyptianMau Mutt Mutt Cymric Mouse Pug Mouse Cymric
 * {EgyptianMau=2, Rat=2, Pet=20, Mouse=2, Cymric=5, Dog=6, Hamster=1, Cat=9, Mutt=3, Rodent=5, Manx=7, Pug=3}
 */