package com.design_mode.structural_patterns.proxy_pattern.model;

/**
 * @author: XueYing.Cao
 * @date: 2019/6/28
 * @description:
 * 步骤2.
 * 接口的具体实现类。
 */
public class Me implements Shopping {
    @Override
    public void shopping() {
        System.out.println("想买东西，不想出门，怎么办？");
    }
}
