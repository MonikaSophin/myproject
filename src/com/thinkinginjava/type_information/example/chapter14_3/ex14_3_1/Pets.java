package com.thinkinginjava.type_information.example.chapter14_3.ex14_3_1;

import com.thinkinginjava.type_information.example.chapter14_3.pets.Pet;
import com.thinkinginjava.type_information.example.chapter14_3.pets.PetCreator;
import java.util.*;

public class Pets {
  public static final PetCreator creator = new LiteralPetCreator();
  public static Pet randomPet() {
    return creator.randomPet();
  }
  public static Pet[] createArray(int size) {
    return creator.createArray(size);
  }
  public static ArrayList<Pet> arrayList(int size) {
    return creator.arrayList(size);
  }
}
