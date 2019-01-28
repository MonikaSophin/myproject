//: typeinfo/pets/ForNameCreator.java
package com.thinkinginjava.type_information.example.chapter14_3.pets;
import java.util.*;

public class ForNameCreator extends PetCreator {
  private static List<Class<? extends Pet>> types = new ArrayList<Class<? extends Pet>>();
  // Types that you want to be randomly created:
  private static String[] typeNames = {
    "com.thinkinginjava.type_information.example.chapter14_3.pets.Mutt",
    "com.thinkinginjava.type_information.example.chapter14_3.pets.Pug",
    "com.thinkinginjava.type_information.example.chapter14_3.pets.EgyptianMau",
    "com.thinkinginjava.type_information.example.chapter14_3.pets.Manx",
    "com.thinkinginjava.type_information.example.chapter14_3.pets.Cymric",
    "com.thinkinginjava.type_information.example.chapter14_3.pets.Rat",
    "com.thinkinginjava.type_information.example.chapter14_3.pets.Mouse",
    "com.thinkinginjava.type_information.example.chapter14_3.pets.Hamster"
  };	
  @SuppressWarnings("unchecked")
  private static void loader() {
    try {
      for(String name : typeNames)
        types.add((Class<? extends Pet>)Class.forName(name));
    } catch(ClassNotFoundException e) {
      throw new RuntimeException(e);
    }
  }
  static { loader(); }
  public List<Class<? extends Pet>> types() {return types;}
} ///:~
