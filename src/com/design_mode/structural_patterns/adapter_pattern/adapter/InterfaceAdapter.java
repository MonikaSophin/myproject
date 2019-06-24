package com.design_mode.structural_patterns.adapter_pattern.adapter;

import com.design_mode.structural_patterns.adapter_pattern.Voltage220V_Interface;
import com.design_mode.structural_patterns.adapter_pattern.Voltage5V;

/**
 * @author: XueYing.Cao
 * @date: 2019/6/24
 * @description:
 * 适配器模式的第三种形式: 接口适配器(实现src, src是接口)
 */
public class InterfaceAdapter implements Voltage5V, Voltage220V_Interface {

    // 或者是这种方式
 /*   private Voltage220V_Interface v =  new Voltage220V_Interface() {
        @Override
        public int inputVoltage() {
            System.out.println("input 5V");
            return 220;
        }
    };*/

    @Override
    public int inputVoltage() {
        int src = 220;
        System.out.println("起始电压: "+ src +"V");
        return src;
    }

    @Override
    public int outputVoltage() {
        int src = inputVoltage();
        System.out.println("接口适配器开始工作...");
        int dest = src / 44;
        System.out.println("接口适配器输出目标电压: "+ dest +"V");
        return dest;
    }
}
