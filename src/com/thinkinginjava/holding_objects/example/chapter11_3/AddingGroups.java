package com.thinkinginjava.holding_objects.example.chapter11_3;

import java.util.*;

/**
 * @Author: monika
 * @Date: 2018/12/11 22:34
 * @Version: 1.0
 * @Description:
 * 1.Collection#addAll()成员方法只能接受另一个Collection对象作为参数，因此它不如
 * Arrays.asList()或Collections.addAll()灵活，这两个方法使用的是可变参数列表。
 *
 * 2.你也可以直接使用Arrays.asList()的输出，将其当作List，但是在这种情况下，其底层
 * 表示的是数组，因此不能调整尺寸。如果你试图用add()或delete()方法在这种列表中添加或
 * 删除元素，就有可能会引发数组尺寸的尝试，因此你将在运行时获得“Unsupported Operation
 * (不支持的操作)”错误。
 */
public class AddingGroups {
    public static void main(String[] args) {
        Collection<Integer> collection
                = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        Integer[] moreInts = {6,7,8,9,10};
        collection.addAll(Arrays.asList(moreInts));

        Collections.addAll(collection,11,12,13,14,15);
        Collections.addAll(collection,moreInts);
        List<Integer> list = Arrays.asList(16,17,18,19,20);
        list.set(1,99);//替换下标为1的元素。
        //! list.add(21); //RuntimeException: UnsupportedOperationException
    }
}
