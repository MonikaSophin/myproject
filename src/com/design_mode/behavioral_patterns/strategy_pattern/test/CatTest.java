package com.design_mode.behavioral_patterns.strategy_pattern.test;

import com.design_mode.behavioral_patterns.strategy_pattern.call.ScreamCall;
import com.design_mode.behavioral_patterns.strategy_pattern.cat.Cat;
import com.design_mode.behavioral_patterns.strategy_pattern.cat.PersianCat;

/**
 * 测试  ：
 *   策略模式
 */
public class CatTest {
    public static void main(String[] args){
        Cat cat = new PersianCat();
        cat.display();
        //可以动态的设置  如不设置则采用默认构造初始化实例
        cat.setCallable(new ScreamCall());
        cat.preformCall();
        cat.preformRun();
    }
}
/**输出：
 * 我是一只波斯猫。
 * 嗷嗷叫--
 * 快速跑--
 */