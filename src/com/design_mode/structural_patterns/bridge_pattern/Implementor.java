package com.design_mode.structural_patterns.bridge_pattern;

/**
 * @author: XueYing.Cao
 * @date: 2019/6/27
 * @description:
 * 1.定义实现类的接口，该接口不一定要与Abstraction的接口完全一致，事实上两个接口可以完全不同。
 * 一般情况，Implementor接口仅为提供基本操作，而Abstraction则定义了基于基本操作的较高层次操作。
 */
public interface Implementor {
    void operation();
}
