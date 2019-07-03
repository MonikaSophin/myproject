package com.design_mode.behavioral_patterns.visitor_pattern;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author: XueYing.Cao
 * @date: 2019/7/3
 * @description:
 * 步骤5.
 * 创建 数据元素集合 对象， 提供接口给访问者
 */
public class ObjectStructure {

    public static List<Element> getElements() {
        List<Element> elements = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            int val = random.nextInt(100);
            if (val > 50) {
                elements.add(new ConcreteElementA());
            } else {
                elements.add(new ConcreteElementB());
            }
        }
        return elements;
    }
}
