package com.thinkinginjava.containers.example.chapter17_3;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import com.thinkinginjava.util.Countries;
import static com.thinkinginjava.util.Print.*;

/**
 * @author: XueYing.Cao
 * @date: 2019/2/25
 * @description:
 */
public class CollectionMethods {
    @SuppressWarnings("unckecked")
    public static void main(String[] args) {
        Collection<String> c = new ArrayList<>();
        c.addAll(Countries.names(6));
        c.add("ten");
        c.add("eleven");
        print(c);

        Object[] array = c.toArray();
        String[] str = c.toArray(new String[0]);
        print("Collections.max(c) = " + Collections.max(c));
        print("Collections.min(c) = " + Collections.min(c));

        Collection<String> c2 = new ArrayList<>();
        c2.addAll(Countries.names(6));
        c.addAll(c2);
        print(c);

        c.remove(Countries.DATA[0][0]);
        print(c);
        c.remove(Countries.DATA[1][0]);
        print(c);

        c.removeAll(c2);
        print(c);
        c.addAll(c2);
        print(c);

        String val = Countries.DATA[3][0];
        print(String.format("c.contains(%s) = %s", val, c.contains(val)));
        print(String.format("c.containsAll(c2) = %s", c.containsAll(c2)));

        Collection<String> c3 = ((ArrayList<String>) c).subList(3,5);
        c2.retainAll(c3);
        print(c2);
        c2.removeAll(c3);
        print(String.format("c2.isEmpty() = %s", c2.isEmpty()));

        c = new ArrayList<>();
        c.addAll(Countries.names(6));
        print(c);
        c.clear();
        print(String.format("after c.clear(): %s", c));
    }
}
/**output:
 * [ALGERIA, ANGOLA, BENIN, BOTSWANA, BURKINA FASO, BURUNDI, ten, eleven]
 * Collections.max(c) = ten
 * Collections.min(c) = ALGERIA
 * [ALGERIA, ANGOLA, BENIN, BOTSWANA, BURKINA FASO, BURUNDI, ten, eleven, ALGERIA, ANGOLA, BENIN, BOTSWANA, BURKINA FASO, BURUNDI]
 * [ANGOLA, BENIN, BOTSWANA, BURKINA FASO, BURUNDI, ten, eleven, ALGERIA, ANGOLA, BENIN, BOTSWANA, BURKINA FASO, BURUNDI]
 * [BENIN, BOTSWANA, BURKINA FASO, BURUNDI, ten, eleven, ALGERIA, ANGOLA, BENIN, BOTSWANA, BURKINA FASO, BURUNDI]
 * [ten, eleven]
 * [ten, eleven, ALGERIA, ANGOLA, BENIN, BOTSWANA, BURKINA FASO, BURUNDI]
 * c.contains(BOTSWANA) = true
 * c.containsAll(c2) = true
 * [ANGOLA, BENIN]
 * c2.isEmpty() = true
 * [ALGERIA, ANGOLA, BENIN, BOTSWANA, BURKINA FASO, BURUNDI]
 * after c.clear(): []
 */