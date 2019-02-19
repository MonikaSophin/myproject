package com.thinkinginjava.generics.example.chapter15_17.ex15_17_3;

import com.thinkinginjava.generics.example.chapter15_17.ex15_17_2.SimpleQueue;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author: XueYing.Cao
 * @date: 2019/2/19
 * @description: 与“任何具有add()的内容”不兼容。有没有“Addable”接口，
 * 所以我们只能使用一个Collection。在这种情况下，我们不能使用泛型进行泛化。
 */
public class Fill {
    public static <T> void fill(Collection<T> collection, Class<? extends T> classToken, int size) {
        for(int i = 0; i < size; i++)
            // 假设有默认构造函数:
            try {
                collection.add(classToken.newInstance());
            } catch(Exception e) {
                throw new RuntimeException(e);
            }
    }
}

class Contract {
    private static long counter = 0;
    private final long id = counter++;
    public String toString() { return getClass().getSimpleName() + " " + id; }
}

class TitleTransfer extends Contract {}

class FillTest {
    public static void main(String[] args) {
        List<Contract> contracts = new ArrayList<>();
        Fill.fill(contracts, Contract.class, 3);
        Fill.fill(contracts, TitleTransfer.class, 2);
        for(Contract c: contracts)
            System.out.println(c);
        SimpleQueue<Contract> contractQueue =
                new SimpleQueue<>();
        // 不能工作。 fill()只能适用于Collection接口，不是通用:
        // Fill.fill(contractQueue, Contract.class, 3);
    }
}
/**output:
 * Contract 0
 * Contract 1
 * Contract 2
 * TitleTransfer 3
 * TitleTransfer 4
 */