package com.design_mode.structural_patterns.adapter_pattern;

/**
 * @author: XueYing.Cao
 * @date: 2019/6/24
 * @description:
 * 适配器模式的第二种形式: 对象适配器(持有src)
 */
public class ObjectAdapter implements Voltage5V {

    private Voltage220V voltage220V;

    public ObjectAdapter() {
        this.voltage220V = new Voltage220V();
    }

    @Override
    public int outputVoltage() {
        int src = voltage220V.inputVoltage();
        System.out.println("对象适配器开始工作...");
        int dest = src / 44;
        System.out.println("对象适配器输出目标电压: "+ dest +"V");
        return dest;
    }
}
