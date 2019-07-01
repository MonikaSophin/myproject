package com.design_mode.behavioral_patterns.iterator_pattern;

/**
 * @author: XueYing.Cao
 * @date: 2019/7/1
 * @description:
 * 步骤3.
 * 实现对应的容器类，在其内部包括一个迭代器实现类。
 */
public class NamesContainer implements Container {

    //内部维护了一个聚合对象
    private String[] names = {"Alex", "Bob", "chocolate", "David", "Eiji"};

    @Override
    public Iterator getIterator() {
        return new NamesIterator();
    }

    public class NamesIterator implements Iterator<String> {

        private int index = 0;

        @Override
        public boolean hasNext() {
            if (index < names.length) {
                return true;
            }
            return false;
        }

        @Override
        public String next() {
            if (hasNext()) {
                return names[index++];
            }
            return null;
        }
    }
}
