package com.thinkinginjava.io.example.chapter18_12.ex18_12_3;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import static com.thinkinginjava.util.Print.*;

/**
 * @author: XueYing.Cao
 * @date: 2019/3/21
 * @description:
 */
class House implements Serializable {}

class Animal implements Serializable {
    private String name;
    private House preferredHouse;
    public Animal(String name, House preferredHouse) {
        this.name = name;
        this.preferredHouse = preferredHouse;
    }
    @Override
    public String toString() {
        return name + "[" + super.toString() + "]. " + preferredHouse + "\n";
    }
}

public class MyWorld {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        House house = new House();
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal("Bosco-the-dog", house));
        animals.add(new Animal("Ralph-the-hamster", house));
        animals.add(new Animal("Molly-the-cat", house));
        print("animals: " + animals);

        ByteArrayOutputStream buf1 = new ByteArrayOutputStream();
        ObjectOutputStream o1 = new ObjectOutputStream(buf1);
        o1.writeObject(animals);
        o1.writeObject(animals);

        ByteArrayOutputStream buf2 = new ByteArrayOutputStream();
        ObjectOutputStream o2 = new ObjectOutputStream(buf2);
        o2.writeObject(animals);

        ObjectInputStream in1 = new ObjectInputStream(
                new ByteArrayInputStream(buf1.toByteArray()));
        ObjectInputStream in2 = new ObjectInputStream(
                new ByteArrayInputStream(buf2.toByteArray()));
        List
                animals1 = (List) in1.readObject(),
                animals2 = (List) in1.readObject(),
                animals3 = (List) in2.readObject();
        print("animals1: " + animals1);
        print("animals2: " + animals2);
        print("animals3: " + animals3);
    }
}
/**output:
 * animals: [Bosco-the-dog[com.thinkinginjava.io.example.chapter18_12.ex18_12_3.Animal@4554617c]. com.thinkinginjava.io.example.chapter18_12.ex18_12_3.House@74a14482
 * , Ralph-the-hamster[com.thinkinginjava.io.example.chapter18_12.ex18_12_3.Animal@1540e19d]. com.thinkinginjava.io.example.chapter18_12.ex18_12_3.House@74a14482
 * , Molly-the-cat[com.thinkinginjava.io.example.chapter18_12.ex18_12_3.Animal@677327b6]. com.thinkinginjava.io.example.chapter18_12.ex18_12_3.House@74a14482
 * ]
 * animals1: [Bosco-the-dog[com.thinkinginjava.io.example.chapter18_12.ex18_12_3.Animal@2f4d3709]. com.thinkinginjava.io.example.chapter18_12.ex18_12_3.House@4e50df2e
 * , Ralph-the-hamster[com.thinkinginjava.io.example.chapter18_12.ex18_12_3.Animal@1d81eb93]. com.thinkinginjava.io.example.chapter18_12.ex18_12_3.House@4e50df2e
 * , Molly-the-cat[com.thinkinginjava.io.example.chapter18_12.ex18_12_3.Animal@7291c18f]. com.thinkinginjava.io.example.chapter18_12.ex18_12_3.House@4e50df2e
 * ]
 * animals2: [Bosco-the-dog[com.thinkinginjava.io.example.chapter18_12.ex18_12_3.Animal@2f4d3709]. com.thinkinginjava.io.example.chapter18_12.ex18_12_3.House@4e50df2e
 * , Ralph-the-hamster[com.thinkinginjava.io.example.chapter18_12.ex18_12_3.Animal@1d81eb93]. com.thinkinginjava.io.example.chapter18_12.ex18_12_3.House@4e50df2e
 * , Molly-the-cat[com.thinkinginjava.io.example.chapter18_12.ex18_12_3.Animal@7291c18f]. com.thinkinginjava.io.example.chapter18_12.ex18_12_3.House@4e50df2e
 * ]
 * animals3: [Bosco-the-dog[com.thinkinginjava.io.example.chapter18_12.ex18_12_3.Animal@34a245ab]. com.thinkinginjava.io.example.chapter18_12.ex18_12_3.House@7cc355be
 * , Ralph-the-hamster[com.thinkinginjava.io.example.chapter18_12.ex18_12_3.Animal@6e8cf4c6]. com.thinkinginjava.io.example.chapter18_12.ex18_12_3.House@7cc355be
 * , Molly-the-cat[com.thinkinginjava.io.example.chapter18_12.ex18_12_3.Animal@12edcd21]. com.thinkinginjava.io.example.chapter18_12.ex18_12_3.House@7cc355be
 * ]
 */