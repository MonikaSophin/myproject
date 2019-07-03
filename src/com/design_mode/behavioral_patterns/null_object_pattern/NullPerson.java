package com.design_mode.behavioral_patterns.null_object_pattern;

/**
 * @author: XueYing.Cao
 * @date: 2019/7/3
 * @description:
 * 步骤3.
 * 创建一个实现Person接口的空对象实例
 */
public class NullPerson implements Person {

    @Override
    public boolean isNull() {
        return true;
    }

    @Override
    public String getName() {
        return "Not Available";
    }
}
