package com.thinkinginjava.util.pets;

import java.util.ArrayList;
import java.util.List;

public class ForNameCreator extends PetCreator {
  private static List<Class<? extends Pet>> types = new ArrayList<>();
  // Types that you want to be randomly created:
  private static String[] typeNames = {
    "com.thinkinginjava.util.pets.Mutt",
    "com.thinkinginjava.util.pets.Pug",
    "com.thinkinginjava.util.pets.EgyptianMau",
    "com.thinkinginjava.util.pets.Manx",
    "com.thinkinginjava.util.pets.Cymric",
    "com.thinkinginjava.util.pets.Rat",
    "com.thinkinginjava.util.pets.Mouse",
    "com.thinkinginjava.util.pets.Hamster"
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
