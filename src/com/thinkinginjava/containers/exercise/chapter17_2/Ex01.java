package com.thinkinginjava.containers.exercise.chapter17_2;

import com.thinkinginjava.util.Countries;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: monika
 * @Date: 2019/2/24 18:20
 * @Version: 1.0
 * @Description: page 470
 * 练习01：创建一个List(用ArrayList和LinkedList都尝试一下)，然后用Countries来填充。
 * 对该列表排序并打印，然后将Collections.shuffle()方法重复地应用于该列表，并且每次都
 * 打印它，这样你就可以看到shuffle()方法是如何每次都将列表随机打乱的了。
 */
public class Ex01 {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        int counter = 3;
        List list1 = new ArrayList(Countries.names(10));
        Collections.sort(list1);
        System.out.println("ArrayList sort: ");
        System.out.println(list1);
        for (int i = 1; i <= counter; i++) {
            Collections.shuffle(list1);
            System.out.println("ArrayList shuffle " + i + " :");
            System.out.println(list1);
        }
        System.out.println();

        List list2 = new LinkedList(Countries.names(10));
        Collections.sort(list2);
        System.out.println("LinkedList sort: ");
        System.out.println(list2);
        for (int i = 1; i <= counter; i++) {
            Collections.shuffle(list2);
            System.out.println("LinkedList shuffle " + i + " :");
            System.out.println(list2);
        }
    }
}
/**output：
 * ArrayList sort:
 * [ALGERIA, ANGOLA, BENIN, BOTSWANA, BURKINA FASO, BURUNDI, CAMEROON, CAPE VERDE, CENTRAL AFRICAN REPUBLIC, CHAD]
 * ArrayList shuffle 1 :
 * [BURKINA FASO, CHAD, BURUNDI, ALGERIA, BOTSWANA, ANGOLA, BENIN, CAMEROON, CENTRAL AFRICAN REPUBLIC, CAPE VERDE]
 * ArrayList shuffle 2 :
 * [BURUNDI, CHAD, BENIN, CAPE VERDE, BOTSWANA, CENTRAL AFRICAN REPUBLIC, ALGERIA, BURKINA FASO, ANGOLA, CAMEROON]
 * ArrayList shuffle 3 :
 * [ALGERIA, ANGOLA, CHAD, BURUNDI, CENTRAL AFRICAN REPUBLIC, CAPE VERDE, BURKINA FASO, CAMEROON, BOTSWANA, BENIN]
 *
 * LinkedList sort:
 * [ALGERIA, ANGOLA, BENIN, BOTSWANA, BURKINA FASO, BURUNDI, CAMEROON, CAPE VERDE, CENTRAL AFRICAN REPUBLIC, CHAD]
 * LinkedList shuffle 1 :
 * [CAPE VERDE, CAMEROON, ALGERIA, BURKINA FASO, CHAD, BURUNDI, BENIN, CENTRAL AFRICAN REPUBLIC, BOTSWANA, ANGOLA]
 * LinkedList shuffle 2 :
 * [CENTRAL AFRICAN REPUBLIC, CHAD, BOTSWANA, BURKINA FASO, CAMEROON, ALGERIA, BURUNDI, ANGOLA, CAPE VERDE, BENIN]
 * LinkedList shuffle 3 :
 * [BOTSWANA, BURKINA FASO, BURUNDI, ALGERIA, CENTRAL AFRICAN REPUBLIC, CAPE VERDE, ANGOLA, CAMEROON, BENIN, CHAD]
 */