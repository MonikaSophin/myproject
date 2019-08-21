package com.monika.jdk8.new_features_for_java.stream_operation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * @author XueYing.Cao
 * @date 2019/8/20
 * Stream的终端操作：
 * 方法返回值类型为void或为其他类型(非Stream)的是 终端操作。
 */
public class TerminalOperation {

    public static void main(String[] args) {
        String[] strs = { "a", "b", "a", "b", "c", "d" };

        /**
         *  终端操作--短路：是指遇到某些符合条件的元素就可以得到最终结果
         */

        //1. 判断数组中 任意元素 是否包含'a'
        // boolean anyMatch(Predicate<T> predicate);
        boolean b1 = Stream.of(strs)
                .anyMatch(e -> "a".equalsIgnoreCase(e));
        System.out.println("anyMatch: " + b1);

        //2. 判断数组中 所有元素 是否 都 包含'a'
        // boolean allMatch(Predicate<T> predicate);
        boolean b2 = Stream.of(strs)
                .allMatch("a"::equalsIgnoreCase);
        System.out.println("allMatch: " + b2);

        //3. 判断数组中 所有元素 是否 都不 包含'a'
        // boolean noneMatch(Predicate<T> predicate);
        boolean b3 = Stream.of(strs)
                .noneMatch("a"::equalsIgnoreCase);
        System.out.println("noneMatch: " + b3);

        //4. 找到数组中第一个元素
        // Optional<T> findFirst();
        Optional<String> first = Stream.of(strs)
                .findFirst();
        System.out.println("findFirst: " + first.get());

        //5. 找到数组中任意一个元素
        // Optional<T> findAny();
        Optional<String> any = Stream.of(strs)
                .findAny();
        System.out.println("findAny: " + any.get());

        /**
         *  终端操作--非短路：是指必须处理所有元素才能得到最终结果。
         */

        //1. 返回Stream中最大元素
        // Optional<T> max(Comparator<T> comparator);
        Optional<String> max = Stream.of(strs)
                .max((e1, e2) -> e1.hashCode() - e2.hashCode());
        System.out.println("max: " + max.get());

        //2. 返回Stream中最小元素
        // Optional<T> min(Comparator<T> comparator);
        Optional<String> min = Stream.of(strs)
                .min(Comparator.comparingInt(String::hashCode));
        System.out.println("min: " + min.get());

        //3. 返回Stream中元素个数
        // long count();
        long count = Stream.of(strs)
                .count();
        System.out.println("count: " + count);

        //4. 返回Stream中元素的数组形式
        // Object[] toArray();
        Object[] toArray = Stream.of(strs)
                .toArray();
        System.out.println("toArray: " + Arrays.toString(toArray));

        //5. 遍历Stream的元素
        // void forEach(Consumer<T> action);
        System.out.print("forEach: ");
        Stream.of(strs)
                .forEach(e -> System.out.print(e + " "));
        System.out.println();

        //6. 按输入顺序遍历Stream的元素
        // void forEachOrdered(Consumer<T> action);
        System.out.print("forEachOrdered: ");
        Stream.of(strs)
                .forEachOrdered(e -> System.out.print(e + " "));
        System.out.println();

        //7. reduce
        // Optional<T> reduce(BinaryOperator<T> accumulator);  accumulator为累加器
        //无初始值，求得最大值
        Optional<String> max1 = Stream.of(strs)
                .reduce((a, b) -> a.hashCode() - b.hashCode() > 0 ? a : b);
        System.out.println("max1: " + max1.get());

        //无初始值，将Stream元素用'-'进行拼接
        Optional<String> reduce = Stream.of(strs)
                .reduce((a, b) -> a + "-" + b);
        System.out.println("reduce: " + reduce.get());

        //有初始值，将Stream元素用'-'进行拼接
        // T reduce(T identity, BinaryOperator<T> accumulator); identity为初始值，accumulator为累加器
        String reduce1 = Stream.of(strs)
                .reduce("", (a, b) -> a + "-" + b);
        System.out.println("reduce1: " + reduce1);

        //计算Stream中元素的总长度
        // U reduce(U identity, BiFunction<U, ? super T, U> accumulator, BinaryOperator<U> combiner);
        // identity为初始值，accumulator为累加器，combiner为组合器（Stream并行时会用到）
        Integer reduce2 = Stream.of(strs)
                .reduce(0, (a, b) -> a + b.length(), (a, b) -> a + b);
        System.out.println("reduce2: " + reduce2);

        //8. collect
        // R collect(Supplier<R> supplier, BiConsumer<R, ? super T> accumulator, BiConsumer<R, R> combiner);
        // supplier为收集操作的目标容器，accumulator为累加器（将值添加进容器），combiner为组合器（Stream并行时会用到）
        System.out.print("collect: ");
        ArrayList<Object> collect = Stream.of(strs)
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        collect.forEach(e -> System.out.print(e + " "));
        System.out.println();

        /**
         * 以上三个参数的简化 ==>  R collect(Collector<? super T, A, R> collector);
         * {@link CollectorsTest}
         */

    }
}
/**output:
 * anyMatch: true
 * allMatch: false
 * noneMatch: false
 * findFirst: a
 * findAny: a
 * max: d
 * min: a
 * count: 6
 * toArray: [a, b, a, b, c, d]
 * forEach: a b a b c d
 * forEachOrdered: a b a b c d
 * max1: d
 * reduce: a-b-a-b-c-d
 * reduce1: -a-b-a-b-c-d
 * reduce2: 6
 * collect: a b a b c d
 */