package com.design_mode.behavioral_patterns.iterator_pattern;

/**
 * @author: XueYing.Cao
 * @date: 2019/7/1
 * @description:
 */
public class Test {

    public static void main(String[] args) {
        NamesContainer namesContainer = new NamesContainer();
        Iterator iterator = namesContainer.getIterator();
        while (iterator.hasNext()) {
            System.out.println("Name : " + iterator.next());
        }

        //或者
//        for (Iterator iterator = namesContainer.getIterator(); iterator.hasNext(); ) {
//            System.out.println("Name : " + iterator.next());
//        }

    }
}
/**output:
 * Name : Alex
 * Name : Bob
 * Name : chocolate
 * Name : David
 * Name : Eiji
 */