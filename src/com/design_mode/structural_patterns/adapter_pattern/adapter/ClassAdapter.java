package com.design_mode.structural_patterns.adapter_pattern.adapter;

import com.design_mode.structural_patterns.adapter_pattern.Voltage220V;
import com.design_mode.structural_patterns.adapter_pattern.Voltage5V;

/**
 * @author: XueYing.Cao
 * @date: 2019/6/24
 * @description:
 * 适配器模式的第一种形式: 类适配器(继承src)
 */
public class ClassAdapter extends Voltage220V implements Voltage5V {
    @Override
    public int outputVoltage() {
        int src = this.inputVoltage();
        System.out.println("类适配器开始工作...");
        int dest = src / 44;
        System.out.println("类适配器输出目标电压: "+ dest +"V");
        return dest;
    }
}
