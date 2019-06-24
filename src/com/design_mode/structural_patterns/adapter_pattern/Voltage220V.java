package com.design_mode.structural_patterns.adapter_pattern;

/**
 * @author: XueYing.Cao
 * @date: 2019/6/24
 * @description:
 *  电压为220V (src)
 */
public class Voltage220V {

    public int inputVoltage() {
        int src = 220;
        System.out.println("起始电压: "+ src +"V");
        return src;
    }
}
