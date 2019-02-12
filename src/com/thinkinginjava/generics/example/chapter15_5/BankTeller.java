package com.thinkinginjava.generics.example.chapter15_5;
import com.thinkinginjava.generics.example.chapter15_3.coffee.Generator;
import com.thinkinginjava.generics.example.chapter15_4.ex15_4_3.Generators;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;

/**
 * @author: XueYing.Cao
 * @date: 2019/2/11
 * @description: 泛型可以应用于内部类以及匿名内部类。
 */
class Customer {
    private static long counter = 1;
    private final long id = counter++;
    private Customer() {}
    @Override
    public String toString() { return "Customer " + id; }
    public static Generator<Customer> generator() {
        return new Generator<Customer>() {
            @Override
            public Customer next() { return new Customer(); }
        };
    }
}

class Teller {
    private static long counter = 1;
    private final long id = counter++;
    private Teller() {}
    @Override
    public String toString() { return "Teller " + id; }
    public static Generator<Teller> generator() {
        return new Generator<Teller>() {
            @Override
            public Teller next() { return new Teller(); }
        };
    }
}

public class BankTeller {
    public static void serve(Teller teller, Customer customer) {
        System.out.println(String.format("%s serves %s", teller, customer));
    }
    public static void main(String[] args) {
        Random rand = new Random(47);
        Queue<Customer> line = new LinkedList<>();
        Generators.fill(line, Customer.generator(), 15);// 填充消费者队列

        List<Teller> tellers = new ArrayList<>();
        Generators.fill(tellers, Teller.generator(), 4);
        for (Customer c : line)
            serve(tellers.get(rand.nextInt(tellers.size())), c);
    }
}
/**output:
 * Teller 3 serves Customer 1
 * Teller 2 serves Customer 2
 * Teller 3 serves Customer 3
 * Teller 1 serves Customer 4
 * Teller 1 serves Customer 5
 * Teller 3 serves Customer 6
 * Teller 1 serves Customer 7
 * Teller 2 serves Customer 8
 * Teller 3 serves Customer 9
 * Teller 3 serves Customer 10
 * Teller 2 serves Customer 11
 * Teller 4 serves Customer 12
 * Teller 2 serves Customer 13
 * Teller 1 serves Customer 14
 * Teller 1 serves Customer 15
 */