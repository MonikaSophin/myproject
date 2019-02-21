package com.thinkinginjava.util.pets;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LiteralPetCreator extends PetCreator {
  @SuppressWarnings("unchecked")
  // 不可修改的List，若为常量则常量不可变；若为引用则引用不可变，引用中数据可变。
  public static final List<Class<? extends Pet>> allTypes =
    Collections.unmodifiableList(Arrays.asList(
      Pet.class, Dog.class, Cat.class,  Rodent.class,
      Mutt.class, Pug.class, EgyptianMau.class, Manx.class,
      Cymric.class, Rat.class, Mouse.class,Hamster.class)
    );

  // Types for random creation:
  private static final List<Class<? extends Pet>> types =
    allTypes.subList(allTypes.indexOf(Mutt.class), allTypes.size());

  public List<Class<? extends Pet>> types() { return types; }

  public static void main(String[] args) {
    System.out.println(types);
  }
}
/**output:
 * [class com.thinkinginjava.util.pets.Mutt, class com.thinkinginjava.util.pets.Pug, class com.thinkinginjava.util.pets.EgyptianMau, class com.thinkinginjava.util.pets.Manx, class com.thinkinginjava.util.pets.Cymric, class com.thinkinginjava.util.pets.Rat, class com.thinkinginjava.util.pets.Mouse, class com.thinkinginjava.util.pets.Hamster]
 */
