package com.thinkinginjava.generics.example.chapter15_12.ex15_12_1;

/**
 * @Author: monika
 * @Date: 2019/2/17 20:18
 * @Version: 1.0
 * @Description:
 */
class GenericType<T> {}

public class CuriouslyRecurringGeneric extends GenericType<CuriouslyRecurringGeneric>{}
