package com.thinkinginjava.generics.example.chapter15_8.ex15_8_1;

/**
 * @author: XueYing.Cao
 * @date: 2019/2/13
 * @description:
 */
class ClassAsFactory<T> {
    T x;
    public ClassAsFactory(Class<T> kind) {
        try {
            x = kind.newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

class Employee {}

public class InstantiateGenericType {
    public static void main(String[] args) {
        ClassAsFactory<Employee> fe = new ClassAsFactory<>(Employee.class);
        System.out.println("ClassAsFactory<Employee> succeeded");
        try {
            ClassAsFactory<Integer> fi = new ClassAsFactory<>(Integer.class);
        }catch (Exception e) {
            System.out.println("ClassAsFactory<Integer> failed => Integer没有默认的无参构造器");
        }
    }
}
/**output:
 * ClassAsFactory<Employee> succeeded
 * ClassAsFactory<Integer> failed => Integer没有默认的无参构造器
 */