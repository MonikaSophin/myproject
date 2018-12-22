package com.thinkinginjava.holding_objects.exercise.chapter11_1;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: monika
 * @Date: 2018/12/11 21:45
 * @Version: 1.0
 * @Description: page 218
 * 练习01:创建一个新类Gerbil(沙鼠)，包含int gerbilNumber，在构造器中初始化它
 * （类似于本章的Mouse示例）。添加一个方法hop()，用以打印沙鼠的号码以及它正在跳跃
 * 的信息。创建一个ArrayList,并向其中添加一串Gerbil对象。使用get()遍历List，
 * 并且对每个Gerbil调用hop()。
 */
class Gerbil {
    private int gerbilNumber;
    public Gerbil(int gerbilNumber) { this.gerbilNumber = gerbilNumber; }
    public void hop() { System.out.println("hoping " + gerbilNumber); }
}

public class Ex01 {
    public static void main(String[] args) {
        List<Gerbil> gerbils = new ArrayList<>();
        for (int i = 1; i <= 5; i++)
            gerbils.add(new Gerbil(i));

        for (int i = 0; i < gerbils.size(); i++)
            gerbils.get(i).hop();
    }
}
/**输出：
 * hoping 1
 * hoping 2
 * hoping 3
 * hoping 4
 * hoping 5
 */