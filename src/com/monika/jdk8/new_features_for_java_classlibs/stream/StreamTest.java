package com.monika.jdk8.new_features_for_java_classlibs.stream;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author: XueYing.Cao
 * @date: 2018/12/5
 * @description:
 *   最新添加的Stream API（java.util.stream） 把真正的函数式编程风格引入到Java中。
 * 这是目前为止对Java类库最好的补充，因为Stream API可以极大提供Java程序员的生产力，
 * 让程序员写出高效率、干净、简洁的代码。
 *
 *   Stream API极大简化了集合框架的处理（但它的处理的范围不仅仅限于集合框架的处理，
 * 这点后面我们会看到）。让我们以一个简单的Task类为例进行介绍：
 */
public class StreamTest {
    private enum Status{
        OPEN,CLOSED
    }
    private static final class Task{
        private final Status status;
        private final Integer points;
        public Task(final Status status,final Integer points) {
            this.status = status;
            this.points = points;
        }
        public Status getStatus() { return status; }
        public Integer getPoints() { return points; }

        @Override
        public String toString() {
            return String.format("[%s,%d]",status,points);
        }
    }

    public static void main(String[] args) {
        final Collection<Task> tasks = Arrays.asList(
                new Task(Status.OPEN,5),
                new Task(Status.OPEN,13),
                new Task(Status.CLOSED,8)
        );
        final long sum = tasks
                .stream()
                .filter(task -> task.getStatus() == Status.OPEN)
                .mapToInt(Task::getPoints)
                .sum();
        System.out.println("Total points: " + sum);

        /**
         *    这里有几个注意事项。第一，task集合被转换化为其相应的stream表示。然后，filter操作
         * 过滤掉状态为CLOSED的task。下一步，mapToInt操作通过Task::getPoints这种方式调用每个
         * task实例的getPoints方法把Task的stream转化为Integer的stream。最后，用sum函数把所有
         * 的分数加起来，得到最终的结果。
         *
         *    在继续讲解下面的例子之前，关于stream有一些需要注意的地方（详情在这里）.stream操作
         * 被分成了中间操作与最终操作这两种。
         *
         *    中间操作返回一个新的stream对象。中间操作总是采用惰性求值方式，运行一个像filter这样
         * 的中间操作实际上没有进行任何过滤，相反它在遍历元素时会产生了一个新的stream对象，这个新
         * 的stream对象包含原始stream中符合给定谓词的所有元素。
         *
         *    像forEach、sum这样的最终操作可能直接遍历stream，产生一个结果或副作用。当最终操作执
         * 行结束之后，stream管道被认为已经被消耗了，没有可能再被使用了。在大多数情况下，最终操作
         * 都是采用及早求值方式，及早完成底层数据源的遍历。
         *
         * stream另一个有价值的地方是能够原生支持并行处理。让我们来看看这个算task分数和的例子。
         */

        final double totalPoints = tasks
                .stream()
                //返回并行的Stream
                .parallel()
                .map(Task::getPoints) // or map(task -> task.getPoints())
                .reduce(0, Integer::sum);
        System.out.println("Total points (all tasks): " + totalPoints);

        /**
         *    上面这个例子和第一个例子很相似，但这个例子的不同之处在于这个程序是并行运行的，其次使用
         *  reduce方法来算最终的结果。
         *
         *    经常会有这个一个需求：我们需要按照某种准则来对集合中的元素进行分组。Stream也可以处理这
         *  样的需求，下面是一个例子：
         */

        Map<Status, List<Task>> collect = tasks
                .stream()
                .collect(Collectors.groupingBy(Task::getStatus));
        System.out.println(collect);

        /**
         *   让我们来计算整个集合中每个task分数（或权重）的平均值来结束task的例子。
         */

        final Collection< String > result = tasks
                .stream()                                        // Stream< String >
                .mapToInt( Task::getPoints )                     // IntStream
                .asLongStream()                                  // LongStream
                .mapToDouble( points -> points / totalPoints )   // DoubleStream
                .boxed()                                         // Stream< Double >
                .mapToLong( weigth -> ( long )( weigth * 100 ) ) // LongStream
                .mapToObj( percentage -> percentage + "%" )      // Stream< String>
                .collect( Collectors.toList() );                 // List< String >
        System.out.println( result );

        /**
         *    最后，就像前面提到的，Stream API不仅仅处理Java集合框架。像从文本文件中
         * 逐行读取数据这样典型的I/O操作也很适合用Stream API来处理。下面用一个例子来
         * 应证这一点。
         *
         *    对一个stream对象调用onClose方法会返回一个在原有功能基础上新增了关闭功能
         * 的stream对象，当对stream对象调用close()方法时，与关闭相关的处理器就会执行。
         *
         *    Stream API、Lambda表达式与方法引用在接口默认方法与静态方法的配合下是Java8
         * 对现代软件开发范式的回应。更多详情请参考官方文档。
         */
        final String fileName = "";
        final Path path = new File(fileName).toPath();
        try( Stream<String> lines = Files.lines(path, StandardCharsets.UTF_8) ){
            lines.onClose(() -> System.out.println("Done!")).forEach(System.out::println);
        } catch (IOException e) {
            System.out.println("IO异常");
        }
    }
}
/**输出：
 * Total points: 18
 * Total points (all tasks): 26.0
 * {OPEN=[[OPEN,5], [OPEN,13]], CLOSED=[[CLOSED,8]]}
 * [19%, 50%, 30%]
 * IO异常
 */