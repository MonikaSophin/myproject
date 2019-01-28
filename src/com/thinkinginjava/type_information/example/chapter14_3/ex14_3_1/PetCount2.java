package com.thinkinginjava.type_information.example.chapter14_3.ex14_3_1;

import com.thinkinginjava.type_information.example.chapter14_3.PetCount;

/**
 * @Author: monika
 * @Date: 2019/1/26 17:34
 * @Version: 1.0
 * @Description:
 */
public class PetCount2 {
    public static void main(String[] args) {
        PetCount.countPets(Pets.creator);
    }
}
/**output:
 * Rat Manx Cymric Mutt Pug Cymric Pug Manx Cymric Rat EgyptianMau Hamster EgyptianMau Mutt Mutt Cymric Mouse Pug Mouse Cymric
 * {EgyptianMau=7, Pug=3, Rat=2, Cymric=7, Mouse=2, Cat=9, Manx=7, Rodent=5, Mutt=3, Dog=6, Pet=20, Hamster=1}
 */