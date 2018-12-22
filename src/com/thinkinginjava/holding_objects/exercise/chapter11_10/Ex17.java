package com.thinkinginjava.holding_objects.exercise.chapter11_10;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @Author: monika
 * @Date: 2018/12/19 22:36
 * @Version: 1.0
 * @Description: page 235
 * 练习17：使用练习01中的Gerbil类，将其放入Map中，将每个Gerbil的名字（例如Fuzzy
 * 或Spot）String（键）与每个Gerbil（值）关联起来。为keyset()获取Iterator,使用
 * 它遍历Map，针对每个“键”查询Gerbil，然后打印出“键”，并让gerbil执行hop。
 */
class Gerbil {
    private int gerbilNumber;
    private String gerbilName;
    public Gerbil(int gerbilNumber, String gerbilName) {
        this.gerbilNumber = gerbilNumber;
        this.gerbilName = gerbilName;
    }
    public void hop() { System.out.println(gerbilName + " hoping " + gerbilNumber); }
}
public class Ex17 {
    public static void main(String[] args) {
        Map<String,Gerbil> gerbils = new HashMap<>();
        gerbils.put("A",new Gerbil(1,"A"));
        gerbils.put("B",new Gerbil(2,"B"));
        gerbils.put("C",new Gerbil(3,"C"));

        Iterator<String> iterator = gerbils.keySet().iterator();
        while(iterator.hasNext()){
            String next = iterator.next();
            Gerbil gerbil = gerbils.get(next);
            gerbil.hop();
        }
    }
}
/**output:
 * A hoping 1
 * B hoping 2
 * C hoping 3
 */