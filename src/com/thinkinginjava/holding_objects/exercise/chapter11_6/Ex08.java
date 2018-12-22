package com.thinkinginjava.holding_objects.exercise.chapter11_6;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Author: monika
 * @Date: 2018/12/15 15:06
 * @Version: 1.0
 * @Description: page 227
 * 练习08：修改练习01，以便调用hop()时食欲Iterator遍历List。
 */
class Gerbil {
    private int gerbilNumber;
    public Gerbil(int gerbilNumber) { this.gerbilNumber = gerbilNumber; }
    public void hop() { System.out.println("hoping " + gerbilNumber); }
}

public class Ex08 {
    public static void main(String[] args) {
        List<Gerbil> gerbils = new ArrayList<>();
        for (int i = 1; i <= 5; i++)
            gerbils.add(new Gerbil(i));

        Iterator<Gerbil> iterator = gerbils.iterator();
        while(iterator.hasNext())
            iterator.next().hop();
    }
}
/**输出：
 * hoping 1
 * hoping 2
 * hoping 3
 * hoping 4
 * hoping 5
 */