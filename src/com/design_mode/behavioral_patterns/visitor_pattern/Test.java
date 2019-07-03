package com.design_mode.behavioral_patterns.visitor_pattern;

import java.util.List;

/**
 * @author: XueYing.Cao
 * @date: 2019/7/3
 * @description:
 */
public class Test {

    public static void main(String[] args) {
        List<Element> elements = ObjectStructure.getElements();
        for (Element element : elements) {
            element.accpt(new ConcreteVisitor());
        }
    }
}
/**output(Sample):
 * ConcreteElementB doSomething!
 * ConcreteElementB doSomething!
 * ConcreteElementA doSomething!
 * ConcreteElementB doSomething!
 * ConcreteElementA doSomething!
 * ConcreteElementA doSomething!
 * ConcreteElementB doSomething!
 * ConcreteElementB doSomething!
 * ConcreteElementB doSomething!
 * ConcreteElementB doSomething!
 */