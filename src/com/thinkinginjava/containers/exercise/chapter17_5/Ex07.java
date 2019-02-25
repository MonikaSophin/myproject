package com.thinkinginjava.containers.exercise.chapter17_5;

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
 * @description: page 477
 * 练习07：分别创建一个ArrayList和LinkedList，用Countries.names()生成器来填充每个
 * 容器。用普通的Iterator打印每个列表，然后用ListIterator按隔一个位置插入一个对象的
 * 方式把一个表插入到另一个表中。现在，从第1个表的末尾开始，向前移动执行插入操作。
 */
public class Ex07 {
    public static void main(String[] args) {
        List<String> al = new ArrayList<>(Countries.names(10));
        List<String> ll = new LinkedList<>(Countries.names(10));

        Iterator<String> ait = al.iterator();
        Iterator<String> lit = ll.iterator();
        while(ait.hasNext())
            printnb(String.format("[%s] ", ait.next()));
        print();
        while(lit.hasNext())
            printnb(String.format("[%s] ", lit.next()));
        print();
        print();


        ListIterator alit = al.listIterator();
        ListIterator llit = ll.listIterator();
        while(llit.hasNext()) {
            alit.next();
            alit.add(llit.next());
        }// al中元素已经移动至末尾
        print(al);
        print();

        List<String> al2 = new ArrayList<>(Countries.names(10));
        ListIterator alit2 = al2.listIterator();
        while(llit.hasPrevious())
            llit.previous(); // 需要将al中元素光标移动至开头
        while(alit2.hasNext())
            alit2.next(); // 需要将al2中元素光标移动至末尾
        while(llit.hasNext()) {//al从头开始遍历
            alit2.add(llit.next());
            alit2.previous();//al2从尾开始遍历
            alit2.previous();
        }
        print(al2);
    }
}
/**output:
 * [ALGERIA] [ANGOLA] [BENIN] [BOTSWANA] [BURKINA FASO] [BURUNDI] [CAMEROON] [CAPE VERDE] [CENTRAL AFRICAN REPUBLIC] [CHAD]
 * [ALGERIA] [ANGOLA] [BENIN] [BOTSWANA] [BURKINA FASO] [BURUNDI] [CAMEROON] [CAPE VERDE] [CENTRAL AFRICAN REPUBLIC] [CHAD]
 *
 * [ALGERIA, ALGERIA, ANGOLA, ANGOLA, BENIN, BENIN, BOTSWANA, BOTSWANA, BURKINA FASO, BURKINA FASO, BURUNDI, BURUNDI, CAMEROON, CAMEROON, CAPE VERDE, CAPE VERDE, CENTRAL AFRICAN REPUBLIC, CENTRAL AFRICAN REPUBLIC, CHAD, CHAD]
 *
 * [ALGERIA, CHAD, ANGOLA, CENTRAL AFRICAN REPUBLIC, BENIN, CAPE VERDE, BOTSWANA, CAMEROON, BURKINA FASO, BURUNDI, BURUNDI, BURKINA FASO, CAMEROON, BOTSWANA, CAPE VERDE, BENIN, CENTRAL AFRICAN REPUBLIC, ANGOLA, CHAD, ALGERIA]
 */