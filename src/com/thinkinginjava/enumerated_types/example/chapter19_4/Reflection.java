package com.thinkinginjava.enumerated_types.example.chapter19_4;

import com.thinkinginjava.util.OSExecute;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Set;
import java.util.TreeSet;

import static com.thinkinginjava.util.Print.*;

/**
 * @author: XueYing.Cao
 * @date: 2019/4/8
 * @description:
 */
enum Explore {
    HERE, THERE,
}

public class Reflection {
    public static Set<String> analyze(Class<?> enumClass) {
        print("----- Analyzing " + enumClass + " -----");

        print("Interfaces:");
        for (Type type : enumClass.getGenericInterfaces())
            print(type);

        print("Base: " + enumClass.getSuperclass());

        print("Methods: ");
        Set<String> methods = new TreeSet<>();
        for (Method m : enumClass.getMethods())
            methods.add(m.getName());
        print(methods);
        return methods;
    }

    public static void main(String[] args) {
        Set<String> exploreMethods = analyze(Explore.class);
        Set<String> enumMethods = analyze(Enum.class);
        print();

        print("Explore.containsAll(Enum)? " + exploreMethods.containsAll(enumMethods));
        printnb("Explore.removeAll(Enum)? ");
        exploreMethods.removeAll(enumMethods);
        print(exploreMethods);
        print();

        OSExecute.command("javap out/production/myproject/com/thinkinginjava/enumerated_types/example/chapter19_4/Explore.class");
    }
}
/**output:
 * ----- Analyzing class com.thinkinginjava.enumerated_types.example.chapter19_4.Explore -----
 * Interfaces:
 * Base: class java.lang.Enum
 * Methods:
 * [compareTo, equals, getClass, getDeclaringClass, hashCode, name, notify, notifyAll, ordinal, toString, valueOf, values, wait]
 * ----- Analyzing class java.lang.Enum -----
 * Interfaces:
 * java.lang.Comparable<E>
 * interface java.io.Serializable
 * Base: class java.lang.Object
 * Methods:
 * [compareTo, equals, getClass, getDeclaringClass, hashCode, name, notify, notifyAll, ordinal, toString, valueOf, wait]
 *
 * Explore.containsAll(Enum)? true
 * Explore.removeAll(Enum)? [values]
 *
 * Compiled from "Reflection.java"
 * final class com.thinkinginjava.enumerated_types.example.chapter19_4.Explore extends java.lang.Enum<com.thinkinginjava.enumerated_types.example.chapter19_4.Explore> {
 *   public static final com.thinkinginjava.enumerated_types.example.chapter19_4.Explore HERE;
 *   public static final com.thinkinginjava.enumerated_types.example.chapter19_4.Explore THERE;
 *   public static com.thinkinginjava.enumerated_types.example.chapter19_4.Explore[] values();
 *   public static com.thinkinginjava.enumerated_types.example.chapter19_4.Explore valueOf(java.lang.String);
 *   static {};
 * }
 */