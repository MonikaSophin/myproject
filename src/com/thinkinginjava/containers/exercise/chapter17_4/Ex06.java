package com.thinkinginjava.containers.exercise.chapter17_4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @author: XueYing.Cao
 * @date: 2019/2/25
 * @description: page 474
 * 练习06：注意：List具有附加的“可选”操作，它们不包含在Collection中。编写一个
 * Unsupported.java版本，测试这些附加的可选操作。
 */
class Unsupported {
    static void test(String msg, List<String> list) {
        System.out.println("--- " + msg + " ---");
        Collection<String> c = list;
        Collection<String> subList = list.subList(1,8);
        // Copy of subList:
        Collection<String> c2 = new ArrayList<>(subList);
        try { c.retainAll(c2); } catch(Exception e) {
            System.out.println("retainAll(): " + e);
        }
        try { c.removeAll(c2); } catch(Exception e) {
            System.out.println("removeAll(): " + e);
        }
        try { c.clear(); } catch(Exception e) {
            System.out.println("clear(): " + e);
        }
        try { c.add("X"); } catch(Exception e) {
            System.out.println("add(): " + e);
        }
        try { c.addAll(c2); } catch(Exception e) {
            System.out.println("addAll(): " + e);
        }
        try { c.remove("C"); } catch(Exception e) {
            System.out.println("remove(): " + e);
        }
        // The List.set() method modifies the value but
        // doesn't change the size of the data structure:
        try { list.set(0, "X"); } catch(Exception e) {
            System.out.println("List.set(): " + e);
        }
        // Additional optional List methods:
        try { list.add(0, "X"); } catch(Exception e) {
            System.out.println("List.add(): " + e);
        }
        try { list.addAll(0, c2); } catch(Exception e) {
            System.out.println("List.addAll(): " + e);
        }
        try { list.remove(0); } catch(Exception e) {
            System.out.println("List.remove(): " + e);
        }
        try { list.removeAll(c2); } catch(Exception e) {
            System.out.println("List.removeAll(): " + e);
        }
        try { list.retainAll(c2); } catch(Exception e) {
            System.out.println("List.retainAll(): " + e);
        }
    }
}

public class Ex06 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("A B C D E F G H I J K L".split(" "));
        Unsupported.test("Modifiabe Copy", new ArrayList<>(list));
        Unsupported.test("Arrays.asList()", list);
        Unsupported.test("unmodifiableLlist()", Collections.unmodifiableList(
                new ArrayList<>(list)));
    }
}
/**output:
 * --- Modifiabe Copy ---
 * --- Arrays.asList() ---
 * retainAll(): java.lang.UnsupportedOperationException
 * removeAll(): java.lang.UnsupportedOperationException
 * clear(): java.lang.UnsupportedOperationException
 * add(): java.lang.UnsupportedOperationException
 * addAll(): java.lang.UnsupportedOperationException
 * remove(): java.lang.UnsupportedOperationException
 * List.add(): java.lang.UnsupportedOperationException
 * List.addAll(): java.lang.UnsupportedOperationException
 * List.remove(): java.lang.UnsupportedOperationException
 * List.removeAll(): java.lang.UnsupportedOperationException
 * List.retainAll(): java.lang.UnsupportedOperationException
 * --- unmodifiableLlist() ---
 * retainAll(): java.lang.UnsupportedOperationException
 * removeAll(): java.lang.UnsupportedOperationException
 * clear(): java.lang.UnsupportedOperationException
 * add(): java.lang.UnsupportedOperationException
 * addAll(): java.lang.UnsupportedOperationException
 * remove(): java.lang.UnsupportedOperationException
 * List.set(): java.lang.UnsupportedOperationException
 * List.add(): java.lang.UnsupportedOperationException
 * List.addAll(): java.lang.UnsupportedOperationException
 * List.remove(): java.lang.UnsupportedOperationException
 * List.removeAll(): java.lang.UnsupportedOperationException
 * List.retainAll(): java.lang.UnsupportedOperationException
 */