package com.monika.jdk8.new_features_for_java.stream_operation;

import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Stream;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * @author XueYing.Cao
 * @date 2019/8/21
 * {@link Stream#collect(Collector)}
 * {@link Collectors}工具类
 */
public class CollectorsTest {

    public static void main(String[] args) {
        Person[] persons = { new Person.Builder().name("Alex").age(20).number(13111).income(2000.0).build(),
                new Person.Builder().name("Bob").age(21).number(13122).income(2010.0).build(),
                new Person.Builder().name("cili").age(19).number(13100).income(1800.0).build() };

        //1. 把Stream中所有元素收集到一个List
        // toList()
        List<Person> list = Stream.of(persons)
                .collect(Collectors.toList());
        list.forEach(System.out::println);
        System.out.println();

        //2. 把Stream中所有元素收集到一个Set
        // toSet()
        Set<Person> set = Stream.of(persons)
                .collect(Collectors.toSet());
        set.forEach(System.out::println);
        System.out.println();

        //3. 把Stream中所有元素收集到一个指定的Collection
        // toCollection()
        LinkedList<Person> linkList = Stream.of(persons)
                .collect(Collectors.toCollection(LinkedList::new));
        linkList.forEach(System.out::println);
        System.out.println();

        //4. 把Stream中所有元素收集到一个Map中，指定元素的属性值作为键
        // toMap()
        Map<String, Object> map = Stream.of(persons)
                .collect(Collectors.toMap(Person::getName, Function.identity()));
        map.entrySet().forEach(System.out::println);
        System.out.println();

        //5. 把Stream中所有元素收集到一个CurrentMap中，指定元素的属性值作为键
        // toCurrentMap()
        Map<String, Object> concurrentMap = Stream.of(persons)
                .collect(Collectors.toConcurrentMap(Person::getName, Function.identity()));
        concurrentMap.entrySet().forEach(System.out::println);
        System.out.println();

        //6. 根据Stream中某个元素的属性值将Stream分组，该元素的属性值作为键，从而组成Map
        // groupingBy()
        Map<String, List<Person>> map1 = Stream.of(persons)
                .collect(Collectors.groupingBy(Person::getName));
        map1.entrySet().forEach(System.out::println);
        System.out.println();

        //6. 根据Stream中某个元素的属性值将Stream分组，该元素的属性值作为键，从而组成CurrentMap
        // groupingByConcurrent()
        Map<String, List<Person>> concurrentMap1 = Stream.of(persons)
                .collect(Collectors.groupingByConcurrent(Person::getName));
        concurrentMap1.entrySet().forEach(System.out::println);
        System.out.println();

        //7. 根据Stream中的每个元素 应用断言函数的结果 分组，断言函数的结果作为键，从而组成Map
        // partitioningBy()
        Map<Boolean, List<Person>> partitioningBy = Stream.of(persons)
                .collect(Collectors.partitioningBy(e -> e.getIncome() >= 2000.0));
        partitioningBy.entrySet().forEach(System.out::println);
        System.out.println();

        //=================================================================================

        //1. 根据传入的收集器收集的结果，转换为 传入的转换函数 对应的结果
        // collectingAndThen()
        Integer collectingAndThen = Stream.of(persons)
                .collect(Collectors.collectingAndThen(Collectors.toList(), List::size));
        System.out.println("collectingAndThen: " + collectingAndThen);

        //2. 计算Stream中元素的个数
        // count()
        Long count = Stream.of(persons)
                .collect(Collectors.counting()); //==> .count()
        System.out.println("count= " + count);

        //3. 对Stream中int/long/double类型的元素求和
        // SummingInt()、summingLong()、summingDouble()
        Integer summingInt = Stream.of(persons)
                .collect(Collectors.summingInt(Person::getAge));//==> .mapToInt(Person::getAge).sum()
        System.out.println("summingInt= " + summingInt);

        //4. 对Stream中int/long/double类型的元素求平均值
        // averagingInt()、averagingLong()、averagingDouble()
        Double averagingInt = Stream.of(persons)
                .collect(Collectors.averagingInt(Person::getAge));
        System.out.println("averagingInt= " + averagingInt);

        //5. 对Stream中int/long/double类型的元素求统计信息（元素个数，元素属性总和，元素属性最小值，元素属性平均值，元素属性最大值）
        // summarizingInt()、summarizingLong()、summarizingDouble()
        IntSummaryStatistics summarizingInt = Stream.of(persons)
                .collect(Collectors.summarizingInt(Person::getAge));
        System.out.println("summarizingInt= " + summarizingInt);

        //7. 连接 对Stream中每个项目调用toString()所有生成的字符串
        // joining()：正常连接每个元素
        String joining1 = Stream.of(persons)
                .map(Person::getName)
                .collect(Collectors.joining());
        System.out.println("joining1 = " + joining1);
        // joining(CharSequence delimiter): 每个元素间添加分隔符
        String joining2 = Stream.of(persons)
                .map(Person::getName)
                .collect(Collectors.joining(", "));
        System.out.println("joining2 = " + joining2);
        // joining(CharSequence delimiter, CharSequence prefix, CharSequence suffix)：每个元素间添加分隔符，最前面添加前缀，最后面添加后缀
        String joining3 = Stream.of(persons)
                .map(Person::getName)
                .collect(Collectors.joining(", ", "{ ", " }"));
        System.out.println("joining3 = " + joining3);

        //8. 从Stream中在给定比较器 选出最大值
        Optional<Person> maxBy = Stream.of(persons)
                .collect(Collectors.maxBy(Comparator.comparingInt(Person::getAge)));//==> .max(Comparator.comparingInt(Person::getAge))
        System.out.println("maxBy: " + maxBy);

        //9. 从Stream中在给定比较器 选出最小值
        Optional<Person> minBy = Stream.of(persons)
                .collect(Collectors.minBy(Comparator.comparingInt(Person::getAge)));//==> .min(Comparator.comparingInt(Person::getAge))
        System.out.println("minBy: " + minBy);

        //10. 归约操作
        Integer reducing = Stream.of(persons)
                .collect(Collectors.reducing(0, Person::getAge, Integer::sum));//==> .map(Person::getAge).reduce(0, Integer::sum);
        System.out.println("reducing: " + reducing);
    }
}
/**output:
 * Person[name='Alex', age=20, number=13111, income=2000.0]
 * Person[name='Bob', age=21, number=13122, income=2010.0]
 * Person[name='cili', age=19, number=13100, income=1800.0]
 *
 * Person[name='Alex', age=20, number=13111, income=2000.0]
 * Person[name='cili', age=19, number=13100, income=1800.0]
 * Person[name='Bob', age=21, number=13122, income=2010.0]
 *
 * Person[name='Alex', age=20, number=13111, income=2000.0]
 * Person[name='Bob', age=21, number=13122, income=2010.0]
 * Person[name='cili', age=19, number=13100, income=1800.0]
 *
 * Alex=Person[name='Alex', age=20, number=13111, income=2000.0]
 * Bob=Person[name='Bob', age=21, number=13122, income=2010.0]
 * cili=Person[name='cili', age=19, number=13100, income=1800.0]
 *
 * Alex=Person[name='Alex', age=20, number=13111, income=2000.0]
 * Bob=Person[name='Bob', age=21, number=13122, income=2010.0]
 * cili=Person[name='cili', age=19, number=13100, income=1800.0]
 *
 * Alex=[Person[name='Alex', age=20, number=13111, income=2000.0]]
 * Bob=[Person[name='Bob', age=21, number=13122, income=2010.0]]
 * cili=[Person[name='cili', age=19, number=13100, income=1800.0]]
 *
 * Alex=[Person[name='Alex', age=20, number=13111, income=2000.0]]
 * Bob=[Person[name='Bob', age=21, number=13122, income=2010.0]]
 * cili=[Person[name='cili', age=19, number=13100, income=1800.0]]
 *
 * false=[Person[name='cili', age=19, number=13100, income=1800.0]]
 * true=[Person[name='Alex', age=20, number=13111, income=2000.0], Person[name='Bob', age=21, number=13122, income=2010.0]]
 *
 * collectingAndThen: 3
 * count= 3
 * summingInt= 60
 * averagingInt= 20.0
 * summarizingInt= IntSummaryStatistics{count=3, sum=60, min=19, average=20.000000, max=21}
 * joining1 = AlexBobcili
 * joining2 = Alex, Bob, cili
 * joining3 = { Alex, Bob, cili }
 * maxBy: Optional[Person[name='Bob', age=21, number=13122, income=2010.0]]
 * minBy: Optional[Person[name='cili', age=19, number=13100, income=1800.0]]
 * reducing: 60
 */