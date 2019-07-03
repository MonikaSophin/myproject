package com.design_mode.behavioral_patterns.null_object_pattern;

/**
 * @author: XueYing.Cao
 * @date: 2019/7/3
 * @description:
 */
public class Test {

    public static void main(String[] args) {
        Person p1 = PersonFactory.getPerson("Alex");
        Person p2 = PersonFactory.getPerson("Rob");
        Person p3 = PersonFactory.getPerson("Bob");
        Person p4 = PersonFactory.getPerson("cc");

        System.out.println("person name:");
        System.out.println(p1.getName());
        System.out.println(p2.getName());
        System.out.println(p3.getName());
        System.out.println(p4.getName());
    }
}
/**output:
 * person name:
 * Alex
 * Not Available
 * Bob
 * Not Available
 */
