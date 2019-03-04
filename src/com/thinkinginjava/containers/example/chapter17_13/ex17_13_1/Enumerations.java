package com.thinkinginjava.containers.example.chapter17_13.ex17_13_1;

import com.thinkinginjava.util.Countries;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Vector;

/**
 * @author: XueYing.Cao
 * @date: 2019/3/4
 * @description:
 */
public class Enumerations {
    public static void main(String[] args) {
        Vector<String> v = new Vector<>(Countries.names(10));
        Enumeration<String> e = v.elements();
        while (e.hasMoreElements())
            System.out.print(e.nextElement() + ", ");
        e = Collections.enumeration(new ArrayList<>());
    }
}
/**output:
 * ALGERIA, ANGOLA, BENIN, BOTSWANA, BURKINA FASO, BURUNDI, CAMEROON, CAPE VERDE, CENTRAL AFRICAN REPUBLIC, CHAD,
 */