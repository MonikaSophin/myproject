package com.thinkinginjava.containers.example.chapter17_4.ex17_4_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @author: XueYing.Cao
 * @date: 2019/2/25
 * @description:
 */
public class Unsupported {
    static void test(String msg, List<String> list) {
        System.out.println(String.format("--- %s ---", msg));
        Collection<String> c = list;
        Collection<String> subList = list.subList(1, 8);
        Collection<String> c2 = new ArrayList<>(subList);
        try{ c.retainAll(c2); }catch (Exception e) {
            System.out.println(String.format("retainAll(): %s", e));
        }
        try{ c.removeAll(c2); }catch (Exception e) {
            System.out.println(String.format("removeAll(): %s", e));
        }
        try{ c.clear(); }catch (Exception e) {
            System.out.println(String.format("clear(): %s", e));
        }
        try{ c.add("X"); }catch (Exception e) {
            System.out.println(String.format("add(): %s", e));
        }
        try{ c.addAll(c2); }catch (Exception e) {
            System.out.println(String.format("addAll(): %s", e));
        }
        try{ c.remove("C"); }catch (Exception e) {
            System.out.println(String.format("remove(): %s", e));
        }

        try{ list.set(0, "X"); }catch (Exception e) {
            System.out.println(String.format("List.set(): %s", e));
        }
    }

    public static void main(String[] args) {
        /**
         * {@link Arrays#asList(Object[])}:返回由指定数组支持的固定大小的列表。
         * 所有改变该列表容量大小的操作都是不支持的，如add()、addAll()、remove()等操作。
         */
        List<String> list = Arrays.asList("A B C D E F G H I J K L".split(" "));
        test("Modifiable Copy", new ArrayList<>(list));
        test("Arrays.asList()", list);

        /**
         * {@link Collections#unmodifiableList(List)} :返回指定列表的不可修改视图。
         * 所有视图改变该列表的方法都是不支持的，如set()、add()、addAll()、remove()、retain()等操作。
         */
        test("unmodifiableList()", Collections.unmodifiableList(
                new ArrayList<>(list)));
    }
}
/**outputL
 * --- Modifiable Copy ---
 * --- Arrays.asList() ---
 * retainAll(): java.lang.UnsupportedOperationException
 * removeAll(): java.lang.UnsupportedOperationException
 * clear(): java.lang.UnsupportedOperationException
 * add(): java.lang.UnsupportedOperationException
 * addAll(): java.lang.UnsupportedOperationException
 * remove(): java.lang.UnsupportedOperationException
 * --- unmodifiableList() ---
 * retainAll(): java.lang.UnsupportedOperationException
 * removeAll(): java.lang.UnsupportedOperationException
 * clear(): java.lang.UnsupportedOperationException
 * add(): java.lang.UnsupportedOperationException
 * addAll(): java.lang.UnsupportedOperationException
 * remove(): java.lang.UnsupportedOperationException
 * List.set(): java.lang.UnsupportedOperationException
 */