package com.design_mode.structural_patterns.adapter_pattern;

import com.design_mode.structural_patterns.adapter_pattern.adapter.ClassAdapter;
import com.design_mode.structural_patterns.adapter_pattern.adapter.InterfaceAdapter;
import com.design_mode.structural_patterns.adapter_pattern.adapter.ObjectAdapter;

/**
 * @author: XueYing.Cao
 * @date: 2019/6/24
 * @description:
 */
public class Test {
    public static void main(String[] args) {
        Client client = new Client();
        client.charging(new ClassAdapter());
        System.out.println("-------");
        client.charging(new ObjectAdapter());
        System.out.println("-------");
        client.charging(new InterfaceAdapter());
    }
}
/**output:
 * 起始电压: 220V
 * 类适配器开始工作...
 * 类适配器输出目标电压: 5V
 * 电压刚好5V，开始充电...
 * -------
 * 起始电压: 220V
 * 对象适配器开始工作...
 * 对象适配器输出目标电压: 5V
 * 电压刚好5V，开始充电...
 * -------
 * 起始电压: 220V
 * 接口适配器开始工作...
 * 接口适配器输出目标电压: 5V
 * 电压刚好5V，开始充电...
 */