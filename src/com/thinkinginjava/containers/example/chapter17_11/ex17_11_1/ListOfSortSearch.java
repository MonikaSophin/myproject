package com.thinkinginjava.containers.example.chapter17_11.ex17_11_1;

import java.util.*;
import com.thinkinginjava.containers.example.chapter17_11.Utilities;
import static com.thinkinginjava.util.Print.*;

/**
 * @Author: monika
 * @Date: 2019/3/3 21:37
 * @Version: 1.0
 * @Description:
 */
public class ListOfSortSearch {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(Utilities.list);
        list.addAll(Utilities.list);
        print("list: " + list);

        Collections.shuffle(list, new Random(47));
        print("shuffled: " + list);

        ListIterator<String> it = list.listIterator(10);
        while (it.hasNext()){
            it.next();
            it.remove();
        }
        print("trimmed: " + list);

        Collections.sort(list);
        print("sorted: " + list);

        String key = list.get(7);
        int index = Collections.binarySearch(list, key);
        print(String.format("Location of %s is %s, list.get(%s) = %s",
                key, index, index, list.get(index)));

        Collections.sort(list, String.CASE_INSENSITIVE_ORDER);
        print("Case_insensitive sorted: " + list);

        key = list.get(7);
        index = Collections.binarySearch(list, key, String.CASE_INSENSITIVE_ORDER);
        print(String.format("Location of %s is %s, list.get(%s) = %s",
                key, index, index, list.get(index)));
    }
}
/**output：
 * list: [one, Two, three, Four, five, six, one, one, Two, three, Four, five, six, one]
 * shuffled: [Four, five, one, one, Two, six, six, three, three, five, Four, Two, one, one]
 * trimmed: [Four, five, one, one, Two, six, six, three, three, five]
 * sorted: [Four, Two, five, five, one, one, six, six, three, three]
 * Location of six is 7, list.get(7) = six
 * Case_insensitive sorted: [five, five, Four, one, one, six, six, three, three, Two]
 * Location of three is 7, list.get(7) = three
 */
