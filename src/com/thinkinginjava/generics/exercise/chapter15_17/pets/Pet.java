//: typeinfo/pets/Pet.java
package com.thinkinginjava.generics.exercise.chapter15_17.pets;

public class Pet extends Individual {
  public Pet(String name) { super(name); }
  public Pet() { super(); }
  public void speak() {
    System.out.println(getClass().getSimpleName() + " speak ");
  }
} ///:~
