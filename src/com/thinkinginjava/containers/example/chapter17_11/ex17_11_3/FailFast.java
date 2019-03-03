package com.thinkinginjava.containers.example.chapter17_11.ex17_11_3;

import java.util.ArrayList;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;

/**
 * @Author: monika
 * @Date: 2019/3/3 23:15
 * @Version: 1.0
 * @Description:
 * java容器类型类库采用了快速报错(fail-fast)机制。它会探查容器上的任何除了
 * 你的进程所进行的操作以外的所有变化，一旦它发现其他进程修改了容器，就会立刻
 * 抛出ConcurrentModificationException异常。
 *
 * {@link java.util.concurrent.ConcurrentHashMap},
 * {@link java.util.concurrent.CopyOnWriteArrayList},
 * {@link java.util.concurrent.CopyOnWriteArraySet},
 * 都使用了可以避免ConcurrentModificationException的技术。
 */
public class FailFast {
    public static void main(String[] args) {
        Collection<String> c = new ArrayList<>();
        /**
         * 程序运行时发生了异常，因为在容器取得迭代器之后，又有东西被放入到了
         * 该容器中。
         * 在这里，应该添加完所有的元素之后，在获取迭代器。
         */
        Iterator<String> it = c.iterator();
        c.add("An Object");
        try {
            String s = it.next();
        } catch (ConcurrentModificationException e) {
            System.out.println(e);
        }
    }
}
/**output:
 * java.util.ConcurrentModificationException
 */