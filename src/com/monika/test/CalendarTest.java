package com.monika.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author: XueYing.Cao
 * @date: 2018/11/30
 * @description: 取得一段时间内的星期天的日期（可用jode-time api代替时间计算）。
 */
public class CalendarTest {
    static public void main(String[] args) throws ParseException {
        String start = "20181101";
        String end = "20181231";
        getSunday(start, end);
    }

    static private void getSunday(String start, String end) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Date date1 = sdf.parse(start);
        Calendar calendar1 = Calendar.getInstance();
        calendar1.setTime(date1);
        //开始时间的解析
        int d1 = getDayOfYear(start);
        //结束时间的解析
        int d2 = getDayOfYear(end);

        for (int i = 0; i < (d2 - d1); i++) {
            String format = sdf.format(calendar1.getTime());
            if (getDayOfWeek(format) == 1)
                System.out.println(format);
            calendar1.add(Calendar.DAY_OF_YEAR, 1);//在前一天基础上加上一天
        }
    }

    //取得time在一星期内的数值，1=>星期天，7=>星期六。以此类推
    static private int getDayOfWeek(String time) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Date date = sdf.parse(time);

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        int i = calendar.get(Calendar.DAY_OF_WEEK);
        return i;
    }

    //取得time的在一年中的天数
    private static int getDayOfYear(String time) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Date date = sdf.parse(time);

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        int i = calendar.get(Calendar.DAY_OF_YEAR);
        return i;
    }
}
/**输出：
 * 20181104
 * 20181111
 * 20181118
 * 20181125
 * 20181202
 * 20181209
 * 20181216
 * 20181223
 * 20181230
 */