package com.design_mode.behavioral_patterns.iterator_pattern;

/**
 * @author: XueYing.Cao
 * @date: 2019/7/1
 * @description:
 * 步骤1.
 * 创建迭代器接口
 */
public interface Iterator<T> {

    boolean hasNext();

    T next();
}
