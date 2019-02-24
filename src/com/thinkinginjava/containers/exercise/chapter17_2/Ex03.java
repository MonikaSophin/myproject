package com.thinkinginjava.containers.exercise.chapter17_2;

import java.util.*;
import java.util.regex.Pattern;
import com.thinkinginjava.util.Countries;
import static com.thinkinginjava.util.Print.*;

/**
 * @Author: monika
 * @Date: 2019/2/24 20:02
 * @Version: 1.0
 * @Description: page 470
 * 练习03：使用Counties,用同样的数据多次填充Set，然后验证此Set中没有重复的元素。
 * 使用HashSet、LinkedHashSet和TreeSet做此测试。
 */
public class Ex03 {
    public static void main(String[] args) {
        Set<String> hs = new HashSet<>();
        Set<String> lhs = new LinkedHashSet<>();
        Set<String> ts = new TreeSet<>();
        print("HashSet hs = " + hs);
        print("LinkedHashSet lhs = " + lhs);
        print("TreeSet ts = " + ts);
        System.out.println();

        Map<String,String> hm = new HashMap<>(0);
        Pattern p = Pattern.compile("Z[a-zA-Z]*");
        for(int i = 0; i < Countries.DATA.length; i++) {
            if(p.matcher(Countries.DATA[i][0]).matches())
                hm.put(Countries.DATA[i][0], Countries.DATA[i][0]);
        }
        print("hm.keySet() = " + hm.keySet());
        System.out.println();

        print("Adding hm.keySet()");
        hs.addAll(hm.keySet());
        lhs.addAll(hm.keySet());
        ts.addAll(hm.keySet());
        print("hs: " + hs);
        print("lhs: " + lhs);
        print("ts: " + ts);
        System.out.println();

        print("Adding 10 more times");
        for(int i = 0; i < 10; i++) {
            hs.addAll(hm.keySet());
            lhs.addAll(hm.keySet());
            ts.addAll(hm.keySet());
        }
        print("hs: " + hs);
        print("lhs: " + lhs);
        print("ts: " + ts);
    }
}
/**output:
 * HashSet hs = []
 * LinkedHashSet lhs = []
 * TreeSet ts = []
 *
 * hm.keySet() = [ZAMBIA, ZIMBABWE]
 *
 * Adding hm.keySet()
 * hs: [ZIMBABWE, ZAMBIA]
 * lhs: [ZAMBIA, ZIMBABWE]
 * ts: [ZAMBIA, ZIMBABWE]
 *
 * Adding 10 more times
 * hs: [ZIMBABWE, ZAMBIA]
 * lhs: [ZAMBIA, ZIMBABWE]
 * ts: [ZAMBIA, ZIMBABWE]
 */