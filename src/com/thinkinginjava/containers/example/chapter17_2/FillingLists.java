package com.thinkinginjava.containers.example.chapter17_2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author: monika
 * @Date: 2019/2/24 17:36
 * @Version: 1.0
 * @Description:
 */
class StringAddress {
    private String s;
    public StringAddress(String s) { this.s = s; }
    @Override
    public String toString() { return super.toString() + " " + s; }
}

public class FillingLists {
    public static void main(String[] args) {
        List<StringAddress> list = new ArrayList<>(
                Collections.nCopies(4, new StringAddress("Hello"))
        );
        System.out.println(list);

        Collections.fill(list, new StringAddress("World!"));
        System.out.println(list);
    }
}
/**
 * [com.thinkinginjava.containers.example.chapter17_2.StringAddress@4554617c Hello, com.thinkinginjava.containers.example.chapter17_2.StringAddress@4554617c Hello, com.thinkinginjava.containers.example.chapter17_2.StringAddress@4554617c Hello, com.thinkinginjava.containers.example.chapter17_2.StringAddress@4554617c Hello]
 * [com.thinkinginjava.containers.example.chapter17_2.StringAddress@74a14482 World!, com.thinkinginjava.containers.example.chapter17_2.StringAddress@74a14482 World!, com.thinkinginjava.containers.example.chapter17_2.StringAddress@74a14482 World!, com.thinkinginjava.containers.example.chapter17_2.StringAddress@74a14482 World!]
 */