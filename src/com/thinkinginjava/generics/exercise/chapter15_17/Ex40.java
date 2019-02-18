package com.thinkinginjava.generics.exercise.chapter15_17;

import com.thinkinginjava.generics.exercise.chapter15_17.pets.Dog;
import com.thinkinginjava.generics.exercise.chapter15_17.pets.Pet;
import com.thinkinginjava.generics.exercise.chapter15_17.pets.Pets;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: monika
 * @Date: 2019/2/18 21:29
 * @Version: 1.0
 * @Description: page 423
 * 练习40：行啊typeinfo.java的所有宠物中添加一个speak()方法。修改Apply.java。使得
 * 我们可以对Pet的异构集合调用speak()。
 */
class Apply40 {
    public static <T,S extends Iterable<? extends T>> void apply(S seq, Method f, Object... args) {
        try {
            for(T t : seq)
                f.invoke(t, args);
        } catch(Exception e) {
            // Failures are programmer errors
            throw new RuntimeException(e);
        }
    }
}

class FilledList<T> extends ArrayList<T> {
    public FilledList(Class<? extends T> type, int size) {
        try {
            for(int i = 0; i < size; i++)
                // Assumes default constructor:
                add(type.newInstance());
        } catch(Exception e) {
            throw new RuntimeException(e);
        }
    }
}
public class Ex40 {
    public static void main(String[] args) throws NoSuchMethodException {
        // 10只宠物的随机清单
        List<Pet> pets = Pets.arrayList(6);
        System.out.println("Random pets: " + pets);
        System.out.println();

        // 应用重写的方法:
        Apply40.apply(pets, Pet.class.getMethod("speak"));
        System.out.println();

        // FilledList只包含一种类型:
        Apply40.apply(new FilledList<Pet>(Dog.class, 3),
                Pet.class.getMethod("speak"));
    }
}
/**output:
 * Random pets: [Rat, Manx, Cymric, Mutt, Pug, Cymric]
 *
 * Rat speak
 * Manx speak
 * Cymric speak
 * Mutt speak
 * Pug speak
 * Cymric speak
 *
 * Dog speak
 * Dog speak
 * Dog speak
 */