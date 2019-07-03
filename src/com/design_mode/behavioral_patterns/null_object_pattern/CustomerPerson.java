package com.design_mode.behavioral_patterns.null_object_pattern;

/**
 * @author: XueYing.Cao
 * @date: 2019/7/3
 * @description:
 * 步骤2.
 * 创建Person接口的实例
 */
public class CustomerPerson implements Person {

    private String name;

    public CustomerPerson(String name) {
        this.name = name;
    }

    @Override
    public boolean isNull() {
        return false;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
