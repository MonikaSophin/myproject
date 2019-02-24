package com.thinkinginjava.containers.exercise.chapter17_2;

import com.thinkinginjava.util.Countries;
import java.util.*;

/**
 * @Author: monika
 * @Date: 2019/2/24 18:33
 * @Version: 1.0
 * @Description: page 470
 * 练习02： 生成一个Map和Set，使其包含所有以字母A开头的国家。
 */
public class Ex02 {
    public static void main(String[] args) {
        List<String> names1 = Countries.names();
        List<String> namesOfA = new LinkedList<>();
        for (String s : names1)
            if (s.startsWith("A"))
                namesOfA.add(s);

        System.out.println("包含字母A开头的国家: ");
        System.out.println(namesOfA);
        System.out.println();


        Map<String, String> capitals = Countries.capitals();
        Map<String, String> capitalsOfA = new LinkedHashMap<>();
        for (Map.Entry<String, String> mape : capitals.entrySet())
            if (mape.getKey().startsWith("A"))
                capitalsOfA.put(mape.getKey(), mape.getValue());

        System.out.println("包含字母A开头的国家与其首都: ");
        System.out.println(capitalsOfA);
    }
}
/**output:
 * 包含字母A开头的国家:
 * [ALGERIA, ANGOLA, AFGHANISTAN, AUSTRALIA, ARMENIA, AZERBAIJAN, ALBANIA, ANDORRA, AUSTRIA, ANTIGUA AND BARBUDA, ARGENTINA]
 *
 * 包含字母A开头的国家与其首都:
 * {ALGERIA=Algiers, ANGOLA=Luanda, AFGHANISTAN=Kabul, AUSTRALIA=Canberra, ARMENIA=Yerevan, AZERBAIJAN=Baku, ALBANIA=Tirana, ANDORRA=Andorra la Vella, AUSTRIA=Vienna, ANTIGUA AND BARBUDA=Saint John's, ARGENTINA=Buenos Aires}
 */