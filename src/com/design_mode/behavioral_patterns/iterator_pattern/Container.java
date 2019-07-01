package com.design_mode.behavioral_patterns.iterator_pattern;

/**
 * @author: XueYing.Cao
 * @date: 2019/7/1
 * @description:
 * 步骤2.
 * 创建容器接口用来获取迭代器
 */
public interface Container {

    Iterator getIterator();
}
