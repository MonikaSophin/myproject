package com.thinkinginjava.containers.example.chapter17_5;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import com.thinkinginjava.util.Countries;
import static com.thinkinginjava.util.Print.*;

/**
 * @author: XueYing.Cao
 * @date: 2019/2/25
 * @description:
 */
public class Lists {
    private static boolean b;
    private static String s;
    private static int i;
    private static Iterator<String> it;
    private static ListIterator<String> lit;
    public static void basicTest(List<String> a) {
        a.add(1, "x");
        a.add("x");

        a.addAll(Countries.names(25));
        a.addAll(3, Countries.names(25)); //从位置3开始

        b = a.contains("1");
        b = a.containsAll(Countries.names(25));

        s = a.get(1);
        i = a.indexOf("1");
        i = a.lastIndexOf("1");
        b = a.isEmpty();

        it = a.iterator();
        lit = a.listIterator();
        lit = a.listIterator(3); //从位置3开始

        a.remove(1);
        a.remove("3");
        a.set(1, "y");

        a.retainAll(Countries.names(25));
        a.retainAll(Countries.names(25));

        i = a.size();
        a.clear();
    }

    public static void iterMotion(List<String> a) {
        ListIterator<String> it = a.listIterator();
        b = it.hasNext();
        b = it.hasPrevious();

        s = it.next();
        i = it.nextIndex();

        s = it.previous();
        i = it.previousIndex();
    }

    public static void iterManipulation(List<String> a) {
        ListIterator<String> it = a.listIterator();
        it.add("47");
        // 必须在add（）之后移动一个元素:
        it.next();

        // 在新生产的元素之后删除元素:
        it.remove();
        // 必须remove()之后必须移动到元素:
        it.next();

        // 更改删除后的元素:
        it.set("47");
    }

    public static void testVisual(List<String> a) {
        print(a);

        List<String> b = Countries.names(25);
        print("b = " + b);

        a.addAll(b);
        a.addAll(b);
        print(a);

        // 使用ListIterator插入，删除和替换元素:
        ListIterator<String> x = a.listIterator(a.size()/2);
        x.add("one");
        print(a);
        print(x.next());
        x.remove();
        print(x.next());
        x.set("47");
        print(a);

        // 向前遍历列表:
        x = a.listIterator(a.size());
        while(x.hasPrevious())
            printnb(x.previous() + " ");
        print();
        print("testVisual finished");
    }

    // 有些东西只有LinkedLists可以做:
    public static void testLinkedList() {
        LinkedList<String> ll = new LinkedList<String>();
        ll.addAll(Countries.names(25));
        print(ll);

        // 像堆栈一样对待它，push:
        ll.addFirst("one");
        ll.addFirst("two");
        print(ll);
        // 就像在堆栈顶部“peeking”一样:
        print(ll.getFirst());
        //就像弹出堆栈一样:
        print(ll.removeFirst());
        print(ll.removeFirst());

        // 把它当成一个队列，从尾端pulling元素:
        print(ll.removeLast());
        print(ll);
    }

    public static void main(String[] args) {
        // Make and fill a new list each time:
        basicTest(
                new LinkedList<>(Countries.names(25)));
        basicTest(
                new ArrayList<>(Countries.names(25)));
        iterMotion(
                new LinkedList<>(Countries.names(25)));
        iterMotion(
                new ArrayList<>(Countries.names(25)));
        iterManipulation(
                new LinkedList<>(Countries.names(25)));
        iterManipulation(
                new ArrayList<>(Countries.names(25)));
        testVisual(
                new LinkedList<>(Countries.names(25)));
        testLinkedList();
    }
}
/**output:
 * [ALGERIA, ANGOLA, BENIN, BOTSWANA, BURKINA FASO, BURUNDI, CAMEROON, CAPE VERDE, CENTRAL AFRICAN REPUBLIC, CHAD, COMOROS, CONGO, DJIBOUTI, EGYPT, EQUATORIAL GUINEA, ERITREA, ETHIOPIA, GABON, THE GAMBIA, GHANA, GUINEA, BISSAU, COTE D'IVOIR (IVORY COAST), KENYA, LESOTHO]
 * b = [ALGERIA, ANGOLA, BENIN, BOTSWANA, BURKINA FASO, BURUNDI, CAMEROON, CAPE VERDE, CENTRAL AFRICAN REPUBLIC, CHAD, COMOROS, CONGO, DJIBOUTI, EGYPT, EQUATORIAL GUINEA, ERITREA, ETHIOPIA, GABON, THE GAMBIA, GHANA, GUINEA, BISSAU, COTE D'IVOIR (IVORY COAST), KENYA, LESOTHO]
 * [ALGERIA, ANGOLA, BENIN, BOTSWANA, BURKINA FASO, BURUNDI, CAMEROON, CAPE VERDE, CENTRAL AFRICAN REPUBLIC, CHAD, COMOROS, CONGO, DJIBOUTI, EGYPT, EQUATORIAL GUINEA, ERITREA, ETHIOPIA, GABON, THE GAMBIA, GHANA, GUINEA, BISSAU, COTE D'IVOIR (IVORY COAST), KENYA, LESOTHO, ALGERIA, ANGOLA, BENIN, BOTSWANA, BURKINA FASO, BURUNDI, CAMEROON, CAPE VERDE, CENTRAL AFRICAN REPUBLIC, CHAD, COMOROS, CONGO, DJIBOUTI, EGYPT, EQUATORIAL GUINEA, ERITREA, ETHIOPIA, GABON, THE GAMBIA, GHANA, GUINEA, BISSAU, COTE D'IVOIR (IVORY COAST), KENYA, LESOTHO, ALGERIA, ANGOLA, BENIN, BOTSWANA, BURKINA FASO, BURUNDI, CAMEROON, CAPE VERDE, CENTRAL AFRICAN REPUBLIC, CHAD, COMOROS, CONGO, DJIBOUTI, EGYPT, EQUATORIAL GUINEA, ERITREA, ETHIOPIA, GABON, THE GAMBIA, GHANA, GUINEA, BISSAU, COTE D'IVOIR (IVORY COAST), KENYA, LESOTHO]
 * [ALGERIA, ANGOLA, BENIN, BOTSWANA, BURKINA FASO, BURUNDI, CAMEROON, CAPE VERDE, CENTRAL AFRICAN REPUBLIC, CHAD, COMOROS, CONGO, DJIBOUTI, EGYPT, EQUATORIAL GUINEA, ERITREA, ETHIOPIA, GABON, THE GAMBIA, GHANA, GUINEA, BISSAU, COTE D'IVOIR (IVORY COAST), KENYA, LESOTHO, ALGERIA, ANGOLA, BENIN, BOTSWANA, BURKINA FASO, BURUNDI, CAMEROON, CAPE VERDE, CENTRAL AFRICAN REPUBLIC, CHAD, COMOROS, CONGO, one, DJIBOUTI, EGYPT, EQUATORIAL GUINEA, ERITREA, ETHIOPIA, GABON, THE GAMBIA, GHANA, GUINEA, BISSAU, COTE D'IVOIR (IVORY COAST), KENYA, LESOTHO, ALGERIA, ANGOLA, BENIN, BOTSWANA, BURKINA FASO, BURUNDI, CAMEROON, CAPE VERDE, CENTRAL AFRICAN REPUBLIC, CHAD, COMOROS, CONGO, DJIBOUTI, EGYPT, EQUATORIAL GUINEA, ERITREA, ETHIOPIA, GABON, THE GAMBIA, GHANA, GUINEA, BISSAU, COTE D'IVOIR (IVORY COAST), KENYA, LESOTHO]
 * DJIBOUTI
 * EGYPT
 * [ALGERIA, ANGOLA, BENIN, BOTSWANA, BURKINA FASO, BURUNDI, CAMEROON, CAPE VERDE, CENTRAL AFRICAN REPUBLIC, CHAD, COMOROS, CONGO, DJIBOUTI, EGYPT, EQUATORIAL GUINEA, ERITREA, ETHIOPIA, GABON, THE GAMBIA, GHANA, GUINEA, BISSAU, COTE D'IVOIR (IVORY COAST), KENYA, LESOTHO, ALGERIA, ANGOLA, BENIN, BOTSWANA, BURKINA FASO, BURUNDI, CAMEROON, CAPE VERDE, CENTRAL AFRICAN REPUBLIC, CHAD, COMOROS, CONGO, one, 47, EQUATORIAL GUINEA, ERITREA, ETHIOPIA, GABON, THE GAMBIA, GHANA, GUINEA, BISSAU, COTE D'IVOIR (IVORY COAST), KENYA, LESOTHO, ALGERIA, ANGOLA, BENIN, BOTSWANA, BURKINA FASO, BURUNDI, CAMEROON, CAPE VERDE, CENTRAL AFRICAN REPUBLIC, CHAD, COMOROS, CONGO, DJIBOUTI, EGYPT, EQUATORIAL GUINEA, ERITREA, ETHIOPIA, GABON, THE GAMBIA, GHANA, GUINEA, BISSAU, COTE D'IVOIR (IVORY COAST), KENYA, LESOTHO]
 * LESOTHO KENYA COTE D'IVOIR (IVORY COAST) BISSAU GUINEA GHANA THE GAMBIA GABON ETHIOPIA ERITREA EQUATORIAL GUINEA EGYPT DJIBOUTI CONGO COMOROS CHAD CENTRAL AFRICAN REPUBLIC CAPE VERDE CAMEROON BURUNDI BURKINA FASO BOTSWANA BENIN ANGOLA ALGERIA LESOTHO KENYA COTE D'IVOIR (IVORY COAST) BISSAU GUINEA GHANA THE GAMBIA GABON ETHIOPIA ERITREA EQUATORIAL GUINEA 47 one CONGO COMOROS CHAD CENTRAL AFRICAN REPUBLIC CAPE VERDE CAMEROON BURUNDI BURKINA FASO BOTSWANA BENIN ANGOLA ALGERIA LESOTHO KENYA COTE D'IVOIR (IVORY COAST) BISSAU GUINEA GHANA THE GAMBIA GABON ETHIOPIA ERITREA EQUATORIAL GUINEA EGYPT DJIBOUTI CONGO COMOROS CHAD CENTRAL AFRICAN REPUBLIC CAPE VERDE CAMEROON BURUNDI BURKINA FASO BOTSWANA BENIN ANGOLA ALGERIA
 * testVisual finished
 * [ALGERIA, ANGOLA, BENIN, BOTSWANA, BURKINA FASO, BURUNDI, CAMEROON, CAPE VERDE, CENTRAL AFRICAN REPUBLIC, CHAD, COMOROS, CONGO, DJIBOUTI, EGYPT, EQUATORIAL GUINEA, ERITREA, ETHIOPIA, GABON, THE GAMBIA, GHANA, GUINEA, BISSAU, COTE D'IVOIR (IVORY COAST), KENYA, LESOTHO]
 * [two, one, ALGERIA, ANGOLA, BENIN, BOTSWANA, BURKINA FASO, BURUNDI, CAMEROON, CAPE VERDE, CENTRAL AFRICAN REPUBLIC, CHAD, COMOROS, CONGO, DJIBOUTI, EGYPT, EQUATORIAL GUINEA, ERITREA, ETHIOPIA, GABON, THE GAMBIA, GHANA, GUINEA, BISSAU, COTE D'IVOIR (IVORY COAST), KENYA, LESOTHO]
 * two
 * two
 * one
 * LESOTHO
 * [ALGERIA, ANGOLA, BENIN, BOTSWANA, BURKINA FASO, BURUNDI, CAMEROON, CAPE VERDE, CENTRAL AFRICAN REPUBLIC, CHAD, COMOROS, CONGO, DJIBOUTI, EGYPT, EQUATORIAL GUINEA, ERITREA, ETHIOPIA, GABON, THE GAMBIA, GHANA, GUINEA, BISSAU, COTE D'IVOIR (IVORY COAST), KENYA]
 */
