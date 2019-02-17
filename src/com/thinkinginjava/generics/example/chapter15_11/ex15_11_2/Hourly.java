package com.thinkinginjava.generics.example.chapter15_11.ex15_11_2;

/**
 * @Author: monika
 * @Date: 2019/2/15 22:00
 * @Version: 1.0
 * @Description:
 */
interface Payable<T> {}

class Employee implements Payable<Employee> {}

/**
 *  不能编译：因为擦除会将Payable<Employee>和Payable<Hourly> 简化为相同的类Payable
 * 这样就意味着在重复两次地实现相同的接口。
 */
//public class Hourly extends Employee implements Payable<Hourly> {}
