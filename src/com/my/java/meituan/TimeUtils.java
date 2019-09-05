package com.my.java.meituan;

import com.google.common.collect.Lists;
import com.google.common.collect.Range;
import org.joda.time.DateTime;
import org.joda.time.Period;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 时间工具类
 * @author liuhuaxin
 * @date 2019-07-22 14:59
 */
public class TimeUtils {

    /**
     * 将时间段拆成一小时一段
     * 并且在12点-18点高峰期，拆成10分钟一段
     * @param timeRange 时间区间
     * @return 时间区间列表
     */
    public static List<Range<Date>> spiltPayTime(Range<Date> timeRange) {
        ArrayList<Range<Date>> result = Lists.newArrayList();
        // 按小时拆分时间段
        Period hourInternal = new Period(TimeUnit.HOURS.toMillis(1L));
        Period tenMinutesInternal = new Period(TimeUnit.MINUTES.toMillis(1L) * 10);
        List<Range<Date>> temp = spiltTime(timeRange, hourInternal);
        for (Range<Date> range : temp) {
            DateTime dateTime = new DateTime(range.lowerEndpoint());
            // 12点-20点是高峰期，拆成10分钟一段
            if (dateTime.getHourOfDay() >= 12 && dateTime.getHourOfDay() < 20 ) {
                List<Range<Date>> ranges = spiltTime(range, tenMinutesInternal);
                result.addAll(ranges);
            } else {
                result.add(range);
            }
        }
        return result;
    }

    /**
     * 将给定时间段按给定时间间隔拆分
     * @param timeRange 时间段
     * @param internal  时间间隔
     * @return 时间区间列表
     */
    public static List<Range<Date>> spiltTime(Range<Date> timeRange, Period internal) {
        List<Range<Date>> timeRangeList = Lists.newArrayList();
        DateTime globalEnd = new DateTime(timeRange.upperEndpoint());
        DateTime start = new DateTime(timeRange.lowerEndpoint());
        while (true) {
            DateTime end = start.plus(internal).minusMillis(1);

            if (end.isAfter(globalEnd)) {
                end = globalEnd;
            }
            timeRangeList.add(Range.closed(start.toDate(), end.toDate()));
            if (!end.isBefore(globalEnd)) {
                break;
            }
            start = start.plus(internal);
        }

        return timeRangeList;
    }

    public static void main(String[] args) {
        List<Range<Date>> ranges = spiltPayTime(Range.closed(new DateTime().withTimeAtStartOfDay().toDate(), new DateTime().withTimeAtStartOfDay().plusDays(1).minusMillis(1).toDate()));
        System.out.println(ranges.size());
        ranges.forEach(range -> {
            System.out.println(new DateTime(range.lowerEndpoint()).toString("yyyy-MM-dd HH:mm:ss:SSS"));
            System.out.println(new DateTime(range.upperEndpoint()).toString("yyyy-MM-dd HH:mm:ss:SSS"));
            System.out.println(range.lowerEndpoint().getTime());
            System.out.println(range.upperEndpoint().getTime());
        });
    }
}