package com.thinkinginjava.enumerated_types.example.chapter19_4;

/**
 * @author: XueYing.Cao
 * @date: 2019/4/12
 * @description:
 */
public class NonEnum {
    public static void main(String[] args) {
        Class<Integer> intClass = Integer.class;
        try {
            for (Integer en : intClass.getEnumConstants())
                System.out.println(en);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
/**output:
 * java.lang.NullPointerException
 */