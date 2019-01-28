package com.thinkinginjava.type_information.example.chapter14_2;

/**
 * @Author: monika
 * @Date: 2019/1/16 22:57
 * @Version: 1.0
 * @Description:
 */
class Candy {
    static { System.out.println("Loading Candy"); }
}

class Gum {
    static { System.out.println("Loading Gum"); }
}

class Cookie {
    static { System.out.println("Loading Cookie"); }
}

public class SweetShop {
    public static void main(String[] args) {
        System.out.println("inside main");
        new Candy();
        System.out.println("After Creating Candy");
        try {
            Class.forName("Gum");
        } catch (ClassNotFoundException e) {
            System.out.println("Couldn't find Gum");
        }
        System.out.println("After Class.forName(\"Gum\")");
        new Cookie();
        System.out.println("After Creating Cookie");
    }
}
/**output:
 * inside main
 * Loading Candy
 * After Creating Candy
 * Couldn't find Gum
 * After Class.forName("Gum")
 * Loading Cookie
 * After Creating Cookie
 */