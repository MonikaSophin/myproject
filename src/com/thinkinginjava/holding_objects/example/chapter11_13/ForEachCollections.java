package com.thinkinginjava.holding_objects.example.chapter11_13;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

/**
 * @Author: monika
 * @Date: 2018/12/22 14:31
 * @Version: 1.0
 * @Description:
 */
public class ForEachCollections {
    public static void main(String[] args) {
        Collection<String> cs = new LinkedList<>();
        Collections.addAll(cs,"Take the long way home".split(" "));
        for (String s : cs)
            System.out.print("'" + s + "' ");
    }
}
/**output:
 * 'Take' 'the' 'long' 'way' 'home'
 */