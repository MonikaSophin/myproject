package com.monika.jdk8.new_features_for_java.stream_operation;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author XueYing.Cao
 * @date 2019/8/19
 * map()与flatMap()的区别：
 *
 * map(): 对每个元素按照某种操作进行转换，转换前后Stream中元素的个数不会改变，
 * 但元素的类型取决于转换之后的类型。
 *
 * flatMap(): 将流进行扁平化。通俗的讲flatMap()的作用就相当于把原stream中的
 * 所有元素都"摊平"之后组成的Stream，转换前后元素的个数和类型都可能会改变。
 */
public class Map_FlatMap {

    public static void main(String[] args) {
        String[] s1 = { "a", "b", "c" };
        String[] s2 = { "c", "d", "e" };

        //map()
        //1. 得到类型为String[]的Stream
        Stream<String[]> d1 = Stream.of(s1, s2);
        //2. 将原Stream中类型为String[]的元素转为List<String>
        Stream<List<String>> d2 = d1.map(e -> Arrays.asList(e));
        //3. 遍历 类型为List<String>的元素
        d2.forEach(e -> System.out.print(e + " "));
        System.out.println();

        //flatMap()
        //1. 得到类型为String[]的Stream
        Stream<String[]> e1 = Stream.of(s1, s2);
        //2. 将原Stream中类型为String[]的元素摊平，其类型则变为String
        Stream<String> e2 = e1.flatMap(e -> Arrays.asList(e).stream());
        //3. 遍历 类型为String的元素
        e2.forEach(e -> System.out.print(e + " "));
    }
}
/**output:
 * [a, b, c] [c, d, e]
 * a b c c d e
 */
