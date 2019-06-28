package com.design_mode.structural_patterns.proxy_pattern.model;

/**
 * @author: XueYing.Cao
 * @date: 2019/6/28
 * @description:
 * 1.目标类(被代理类)：
 *   首先，定义一个类，该类没有实现任何接口。
 */
public class MeCglib {
    // 可以被代理
    public void shopping() {
        System.out.println("想买东西，但是不想动...");
    }

    // final 方法不会被生成的字类覆盖
    public final void working() {
        System.out.println("我正在工作");
    }

    // private 方法不会被生成的字类覆盖
    private void playing() {
        System.out.println("我正在玩游戏");
    }
}
