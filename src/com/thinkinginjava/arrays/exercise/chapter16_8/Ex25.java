package com.thinkinginjava.arrays.exercise.chapter16_8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;
import static com.thinkinginjava.util.Print.*;

/**
 * @author: XueYing.Cao
 * @date: 2019/2/22
 * @description: page 458
 * 练习25：用Java重写PythonList.py。
 * python中#号为注释
 *
 *   #PythonList.py
 *
 *   aList = [1, 2, 3, 4, 5]
 *   print type(aList) # <类型 'list'>
 *   print aList # 输出:[1, 2, 3, 4, 5]
 *   print aList[4] # 输出:5  基本list索引
 *   aList.append(6) # 列表可以调整大小
 *   aList += [7. 8] # 添加一个list到一个list
 *   print aList # 输出:[1, 2, 3, 4, 5, 6, 7, 8]
 *   aSlice = aList[2:4]
 *   print aSlice # 输出:[3, 4]
 *
 *   class MyList(list): # 继承list
 *   # 定义一个方法: 'this'指针是明确的
 *   def getReversed(self):
 *       reversed = self[:] # 用切片复制list
 *       reversed.reverse() # 内置的list方法
 *       return reversed
 *
 *   list2 = MyList(aList) # 无需'new'去创建
 *   print type(list2) # <class '_main_.MyList'>
 *   print list2.getReversed() # 输出:[8, 7, 6, 5, 4, 3, 2, 1]
 */
class MyList extends ArrayList {
    List myList;
    MyList(List myList) { this.myList = myList; }
    @SuppressWarnings("unchecked")
    MyList getReversed() {
        ListIterator lit = myList.listIterator(myList.size());
        List reverseMyList = new ArrayList();
        while(lit.hasPrevious())
            reverseMyList.add(lit.previous());
        return new MyList(reverseMyList);
    }
}

public class Ex25 {
    public static void main(String[] args) {
        List<Integer> aList = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        print(aList);
        print(aList.get(4));
        aList.add(6);
        aList.addAll(new ArrayList<>(Arrays.asList(7,8)));
        print(aList);

        /**
         * {@link List#subList(from, to)} :
         * 表示左闭右开区间 => [from, to)
         */
        print(aList.subList(2,4));
        MyList ml = new MyList(aList);
        print((ml.getReversed()).myList);
    }
}
/**output:
 * [1, 2, 3, 4, 5]
 * 5
 * [1, 2, 3, 4, 5, 6, 7, 8]
 * [3, 4]
 * [8, 7, 6, 5, 4, 3, 2, 1]
 */