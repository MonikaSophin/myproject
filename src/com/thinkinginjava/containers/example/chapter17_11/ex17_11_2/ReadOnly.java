package com.thinkinginjava.containers.example.chapter17_11.ex17_11_2;

import java.util.*;

import com.thinkinginjava.util.Countries;
import static com.thinkinginjava.util.Print.*;

/**
 * @Author: monika
 * @Date: 2019/3/3 22:59
 * @Version: 1.0
 * @Description:
 */
public class ReadOnly {
    static Collection<String> data = new ArrayList<>(Countries.names(6));
    public static void main(String[] args) {
        Collection<String> c = Collections.unmodifiableCollection(
                new ArrayList<>(data));
        print(c);// “读”可以
        //运行异常：UnsupportedOperationException
        // c.add("one");// “写”不行

        List<String> a = Collections.unmodifiableList(
                new ArrayList<>(data));
        ListIterator<String> lit = a.listIterator();
        print(lit.next());// “读”可以
        //运行异常：UnsupportedOperationException
        // lit.set("one");// “写”不行

        Set<String> s = Collections.unmodifiableSet(
                new HashSet<>(data));
        print(s);// “读”可以
        //运行异常：UnsupportedOperationException
        // s.add("one");// “写”不行

        SortedSet<String> ss = Collections.unmodifiableSortedSet(
                new TreeSet<>(data));

        Map<String, String> m = Collections.unmodifiableMap(
                new HashMap<>(Countries.capitals(6)));
        print(m);// “读”可以
        //运行异常：UnsupportedOperationException
        // m.put("Ralph", "Howdy!");// “写”不行

        SortedMap<String, String> sm = Collections.unmodifiableSortedMap(
                new TreeMap<>(Countries.capitals(6)));
    }
}
/**output:
 * [ALGERIA, ANGOLA, BENIN, BOTSWANA, BURKINA FASO, BURUNDI]
 * ALGERIA
 * [BENIN, BOTSWANA, ANGOLA, BURKINA FASO, ALGERIA, BURUNDI]
 * {BENIN=Porto-Novo, BOTSWANA=Gaberone, ANGOLA=Luanda, BURKINA FASO=Ouagadougou, ALGERIA=Algiers, BURUNDI=Bujumbura}
 */