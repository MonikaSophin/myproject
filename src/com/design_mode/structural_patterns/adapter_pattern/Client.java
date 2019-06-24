package com.design_mode.structural_patterns.adapter_pattern;

/**
 * @author: XueYing.Cao
 * @date: 2019/6/24
 * @description:
 * 客户端，消费适配器--手机
 */
public class Client {
    //充电方法，传入实现5V的适配器
    public void charging(Voltage5V voltage5V) {
        int dest = voltage5V.outputVoltage();
        if (dest == 5) {
            System.out.println("电压刚好5V，开始充电...");
        } else {
            System.out.println("不是5V，要爆炸...");
        }
    }
}
