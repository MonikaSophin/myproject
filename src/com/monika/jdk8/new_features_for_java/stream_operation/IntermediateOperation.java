package com.monika.jdk8.new_features_for_java.stream_operation;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * @author XueYing.Cao
 * @date 2019/8/19
 * Stream的中间操作：
 * 方法返回值类型为Stream的是 中间操作。
 */
public class IntermediateOperation {

    public static void main(String[] args) {
        Person[] persons = { new Person.Builder().name("Alex").age(20).number(13111).income(2000.0).build(),
                new Person.Builder().name("Bob").age(21).number(13122).income(2010.0).build(),
                new Person.Builder().name("cili").age(19).number(13100).income(1800.0).build() };

        /**
         *  中间操作--无状态：是指元素的处理不受之前元素的影响。
         */

        //1. 获取名称为Alex的Person
        // Stream<T> filter(Predicate<? super T> predicate);
        Arrays.stream(persons)
                .filter(e -> "Alex".equalsIgnoreCase(e.getName()))
                .forEach(System.out::println);

        //2.1 获取该流的所有Person的姓名
        // <R> Stream<R> map(Function<? super T, ? extends R> mapper);
        Arrays.stream(persons)
                .map(Person::getName) //.map(e -> e.getName())
                .forEach(e -> System.out.print(e + " "));
        System.out.print("      ");

        //2.2 获取该流的所有Person的姓名
        // <R> Stream<R> flatMap(Function<? super T, ? extends Stream<? extends R>> mapper);
        Arrays.stream(persons)
                .flatMap(e -> Stream.of(e.getName()))
                .forEach(e -> System.out.print(e + " "));
        System.out.println();

        //3.1 获取该流的所有Person的年龄
        // IntStream mapToInt(ToIntFunction<? super T> mapper);
        Arrays.stream(persons)
                .mapToInt(Person::getAge)
                .forEach(e -> System.out.print(e + " "));
        System.out.print("      ");

        //3.2 获取该流的所有Person的年龄
        // IntStream flatMapToInt(Function<? super T, ? extends IntStream> mapper);
        Arrays.stream(persons)
                .flatMapToInt(e -> IntStream.of(e.getAge()))
                .forEach(e -> System.out.print(e + " "));
        System.out.println();

        //4.1 获取该流的所有Person的号码
        // LongStream mapToLong(ToLongFunction<? super T> mapper);
        Arrays.stream(persons)
                .mapToLong(Person::getNumber)
                .forEach(e -> System.out.print(e + " "));
        System.out.print("      ");

        //4.2 获取该流的所有Person的号码
        // LongStream flatMapToLong(Function<? super T, ? extends LongStream> mapper);
        Arrays.stream(persons)
                .flatMapToLong(e -> LongStream.of(e.getNumber()))
                .forEach(e -> System.out.print(e + " "));
        System.out.println();

        //5.1 获取该流的所有Person的收入
        // DoubleStream mapToDouble(ToDoubleFunction<? super T> mapper);
        Arrays.stream(persons)
                .mapToDouble(Person::getIncome)
                .forEach(e -> System.out.print(e + " "));
        System.out.print("      ");

        //5.2 获取该流的所有Person的收入
        // DoubleStream flatMapToDouble(Function<? super T, ? extends DoubleStream> mapper);
        Arrays.stream(persons)
                .flatMapToDouble(e -> DoubleStream.of(e.getIncome()))
                .forEach(e -> System.out.print(e + " "));
        System.out.println();

        //6. 一般查看流中的操作
        // Stream<T> peek(Consumer<? super T> action);
        Arrays.stream(persons)
                .peek(person -> System.out.print(person.getName() + "\t"))
                .forEach(System.out::println);

        //7. 返回无序的等效流
        Stream<Person> unordered = Arrays.stream(persons).unordered();

        //8. 返回串行的等效流
        Stream<Person> sequential = Arrays.stream(persons).sequential();

        //9. 返回并行的等效流
        Stream<Person> parallel = Arrays.stream(persons).parallel();
        System.out.println();

        /**
         *  中间操作--有状态：是指该操作只有拿到所有元素之后才能继续下去。
         */

        String[] strs = { "b", "a", "b", "a", "d", "c", "f", "e"};
        Stream.of(strs)
                .forEach(e -> System.out.print(e + " "));
        System.out.println();

        //1. Stream<T> distinct(); 按照equals()进行对比，如有需要，
        Stream.of(strs)
                .distinct()
                .forEach(e -> System.out.print(e + " "));
        System.out.println();

        //2. Stream<T> sorted(); 按自然顺序排序
        Stream.of(strs)
                .sorted()
                .forEach(e -> System.out.print(e + " "));
        System.out.println();

        // Stream<T> sorted(Comparator<? super T> comparator); 按自定义比较器的排序
        Stream.of(persons)
                .sorted(Comparator.comparingInt(Person::getAge))
                .forEach(e -> System.out.printf("%s:%s", e.getName(), e.getAge() + " "));
        System.out.println();

        //3. Stream<T> limit(long maxSize); 返回由此流的元素组成的流，截断的长度不超过maxSize
        Stream.of(strs)
                .limit(5)
                .forEach(e -> System.out.print(e + " "));
        System.out.println();

        //4. Stream<T> skip(long n); 丢弃第1个到第n个元素，返回剩下的元素
        Stream.of(strs)
                .skip(5)
                .forEach(e -> System.out.print(e + " "));
        System.out.println();

        //5. Stream<T> concat(Stream<T> a, Stream<T> b);
        // 创建一个懒惰连接的流，其元素是第一个流的所有元素，后跟第二个流的所有元素。
        String[] strs2 = { "b", "a", "y", "z" };
        Stream.concat(Stream.of(strs), Stream.of(strs2))
                .forEach(e -> System.out.print(e + " "));
    }
}
/**output:
 * Person[name='Alex', age=20, number=13111, income=2000.0]
 * Alex Bob cili       Alex Bob cili
 * 20 21 19       20 21 19
 * 13111 13122 13100       13111 13122 13100
 * 2000.0 2010.0 1800.0       2000.0 2010.0 1800.0
 * Alex	Person[name='Alex', age=20, number=13111, income=2000.0]
 * Bob	Person[name='Bob', age=21, number=13122, income=2010.0]
 * cili	Person[name='cili', age=19, number=13100, income=1800.0]
 *
 * b a b a d c f e
 * b a d c f e
 * a a b b c d e f
 * cili:19 Alex:20 Bob:21
 * b a b a d
 * c f e
 * b a b a d c f e b a y z
 */