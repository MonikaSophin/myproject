package com.design_mode.behavioral_patterns.null_object_pattern;

/**
 * @author: XueYing.Cao
 * @date: 2019/7/3
 * @description:
 * 步骤4.
 * 创建一个Person类的工厂
 */
public class PersonFactory {

    public static final String[] names = {"Alex", "Bob", "chocolate"};

    public static Person getPerson(String name) {
        for (String s : names) {
            if (s.equalsIgnoreCase(name)) {
                return new CustomerPerson(s);
            }
        }
        return new NullPerson();
    }
}
