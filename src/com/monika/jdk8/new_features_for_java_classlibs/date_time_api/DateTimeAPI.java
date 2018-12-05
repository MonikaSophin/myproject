package com.monika.jdk8.new_features_for_java_classlibs.date_time_api;

import java.time.*;

/**
 * @author: XueYing.Cao
 * @date: 2018/12/5
 * @description:
 * Java 8通过发布新的Date-Time API (JSR 310)来进一步加强对日期与时间的处理。
 * 对日期与时间的操作一直是Java程序员最痛苦的地方之一。标准的 java.util.Date以及
 * 后来的java.util.Calendar一点没有改善这种情况（可以这么说，它们一定程度上更加复杂）。
 * <p>
 * 这种情况直接导致了Joda-Time——一个可替换标准日期/时间处理且功能非常强大的Java API
 * 的诞生。Java 8新的Date-Time API (JSR 310)在很大程度上受到Joda-Time的影响，并且
 * 吸取了其精髓。新的java.time包涵盖了所有处理日期，时间，日期/时间，时区，时刻（instants），
 * 过程（during）与时钟（clock）的操作。在设计新版API时，十分注重与旧版API的兼容性：
 * 不允许有任何的改变（从java.util.Calendar中得到的深刻教训）。如果需要修改，会返回
 * 这个类的一个新实例。
 * <p>
 * 让我们用例子来看一下新版API主要类的使用方法。第一个是Clock类，它通过指定一个时区，
 * 然后就可以获取到当前的时刻，日期与时间。Clock可以替换System.currentTimeMillis()
 * 与TimeZone.getDefault()。
 */
public class DateTimeAPI {
    public static void main(String[] args) {
        final Clock clock = Clock.systemUTC();
        System.out.println(clock.instant());
        System.out.println(clock.millis());
        System.out.println();

        /**
         *   我们需要关注的其他类是LocaleDate与LocalTime。LocaleDate只持有ISO-8601格式
         * 且无时区信息的日期部分。相应的，LocaleTime只持有ISO-8601格式且无时区信息的时间
         * 部分。LocaleDate与LocalTime都可以从Clock中得到。
         */

        // Get the local date and local time
        final LocalDate date = LocalDate.now();
        final LocalDate dateFromClock = LocalDate.now(clock);
        System.out.println(date);
        System.out.println(dateFromClock);
        final LocalTime time = LocalTime.now();
        final LocalTime timeFromClock = LocalTime.now(clock);
        System.out.println(time);
        System.out.println(timeFromClock);
        System.out.println();

        /**
         *    LocaleDateTime把LocaleDate与LocaleTime的功能合并起来，它持有的是ISO-8601格式
         * 无时区信息的日期与时间。下面是一个快速入门的例子。
         */

        // Get the local date/time
        final LocalDateTime datetime = LocalDateTime.now();
        final LocalDateTime datetimeFromClock = LocalDateTime.now(clock);
        System.out.println(datetime);
        System.out.println(datetimeFromClock);
        System.out.println();

        /**
         *    如果你需要特定时区的日期/时间，那么ZonedDateTime是你的选择。它持有ISO-8601格式
         * 具有时区信息的日期与时间。下面是一些不同时区的例子：
         */

        final ZonedDateTime zonedDateTime = ZonedDateTime.now();
        final ZonedDateTime zonedDateTimeFromClock = ZonedDateTime.now(clock);
        final ZonedDateTime zonedDateTimeFromZone = ZonedDateTime.now(ZoneId.of("America/Los_Angeles"));
        System.out.println(zonedDateTime);
        System.out.println(zonedDateTimeFromClock);
        System.out.println(zonedDateTimeFromZone);
        System.out.println();

        /**
         *    最后，让我们看一下Duration类：在秒与纳秒级别上的一段时间。Duration使计算两个日期间
         * 的不同变的十分简单。下面让我们看一个这方面的例子。
         */

        final LocalDateTime from = LocalDateTime.of(2018,Month.DECEMBER,5,12,0,0);
        final LocalDateTime to = LocalDateTime.of(2018,Month.DECEMBER,6,14,30,0);
        final Duration duration = Duration.between(from,to);
        System.out.println("Duration in days: " + duration.toDays());
        System.out.println("Duration in hours: " + duration.toHours());
        System.out.println();

        /**
         *    对Java 8在日期/时间API的改进整体印象是非常非常好的。一部分原因是因为它建立在“久战杀场”
         * 的Joda-Time基础上，另一方面是因为用来大量的时间来设计它，并且这次程序员的声音得到了认可。
         * 更多详情请参考官方文档。
         */
    }
}
/**输出：
 * 2018-12-05T04:29:40.065Z
 * 1543984180143
 *
 * 2018-12-05
 * 2018-12-05
 * 12:29:40.158
 * 04:29:40.158
 *
 * 2018-12-05T12:29:40.158
 * 2018-12-05T04:29:40.158
 *
 * 2018-12-05T12:29:40.158+08:00[Asia/Shanghai]
 * 2018-12-05T04:29:40.158Z
 * 2018-12-04T20:29:40.158-08:00[America/Los_Angeles]
 *
 * Duration in days: 1
 * Duration in hours: 26
 */
