package com.bluemyth.framework.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 * Created by xiaot on 2017/4/17.
 */
public class Date2Util {

    public static String DEFAULT_PATTERN = "yyyy-MM-dd";

    public static String HOUR_PATTERN = "yyyy-MM-dd HH";

    public static String MONTH_PATTERN = "yyyy-MM";

    public static String MINUTE_PATTERN = "yyyy-MM-dd HH:mm";

    public static String SENCOND_PATTERN = "yyyy-MM-dd HH:mm:ss";

    public static void main(String[] args) {
        //Date2Util.getBetweenDays(Date2Util.parseDate("2018-04-08"), new Date());
        //getStartEndFromMonth(Date2Util.parseDate("2018-01-01"));
        getWeekDaysOfMonth(2017,0);
        //System.out.println(getWeekOfYear(Date2Util.parseDate("2018-01-01")));
    }

    public static Date parseDate(String s) {
        return parseDate(s, DEFAULT_PATTERN);
    }

    public static Date parseDate(String s, String pattern) {
        if (pattern == null) pattern = DEFAULT_PATTERN;
        try {
            SimpleDateFormat format = new SimpleDateFormat(pattern);
            return format.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String parseDateToString(Date date) {
        if (date == null) {
            return "";
        }
        return parseDateToString(date, DEFAULT_PATTERN);
    }

    public static String parseDateToString(Date date, String pattern) {
        if (date == null) return "";
        try {
            if (pattern == null) pattern = DEFAULT_PATTERN;
            SimpleDateFormat df = new SimpleDateFormat(pattern);
            return df.format(date);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    //获取指定日期所在月第一天和最后一天
    public static String[] getStartEndFromMonth(Date date) {
        String[] arr = new String[2];
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int dayNumOfMonth = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        String start = parseDateToString(cal.getTime());
        cal.set(Calendar.DAY_OF_MONTH, dayNumOfMonth);
        String end = parseDateToString(cal.getTime());
        arr[0] = start;
        arr[1] = end;
        return arr;
    }

    //获取指定日期所在月的所有日期
    public static List<String> getDaysFromMonth(Date date) {
        List<String> days = new ArrayList<String>();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int dayNumOfMonth = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        for (int i = 0; i < dayNumOfMonth; i++, cal.add(Calendar.DATE, 1)) {
            String df = parseDateToString(cal.getTime());
            //System.out.println(df);
            days.add(df);
        }
        return days;
    }

    //获取指定日期区间之间的日期
    public static List<String> getBetweenDays(Date startDate, Date endDate) {
        List<String> days = new ArrayList<String>();
        long start = startDate.getTime();
        long end = endDate.getTime();
        if (start <= end) {
            double a = (end - start) / (1000 * 60 * 60 * 24l);
            int dayNumOfMonth = (int) Math.ceil((end - start) / (1000 * 60 * 60 * 24l));
            Calendar cal = Calendar.getInstance();
            cal.setTime(startDate);
            for (int i = 0; i <= dayNumOfMonth; i++, cal.add(Calendar.DATE, 1)) {
                String df = parseDateToString(cal.getTime());
                //System.out.println(df);
                days.add(df);
            }
        }
        return days;
    }

    /**
     * 增加天数
     * @param date
     * @param d
     * @return
     */
    public static Date addDays(Date date, int d) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, d);
        return cal.getTime();
    }

    /**
     * 格式增加天数
     * @param date
     * @param d
     * @return
     */
    public static String getAddDaysString(Date date, int d) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, d);
        return parseDateToString(cal.getTime());
    }

    //获取指定年所有周
    public static  List<String[]> getWeekDaysOfYear(int year){
        List<String[]> list = new ArrayList();
        int max_week = getMaxWeekNumOfYear(year);
        for(int i=1;i<=max_week;i++){
            Date first = getFirstDayOfWeek(year,i);
            Date last = getLastDayOfWeek(year,i);
            String first_str = parseDateToString(first);
            String last_str = parseDateToString(last);

            System.out.println(i +": " + first_str + "~"  + last_str);
            list.add(new String[]{ first_str , last_str });
        }
        return list;
    }

    //获取指定日期所在月所有周
    public static  List<String[]> getWeekDaysOfMonth(int year,int month){
        List<String[]> list = new ArrayList();
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR,year);
        cal.set(Calendar.MONTH,month);
        cal.set(Calendar.DATE, 1);
        int max_week_month = getMaxWeekNumOfMonth(cal.getTime());
        int index_week_year = getWeekOfYear(cal.getTime());

         for(int i=0;i<max_week_month;i++){
            int real_index = i + index_week_year;
            Date first = getFirstDayOfWeek(year,real_index);
            if(i==0) {
                int _month = Date2Util.getMonthOfDate(first);//剔除1号所在周夸月的
                if(_month != month) continue;
            }

            Date last = getLastDayOfWeek(year,real_index);
            String first_str = parseDateToString(first);
            String last_str = parseDateToString(last);
            //System.out.println(real_index +": " + first_str + "~"  + last_str);
            list.add(new String[]{ first_str , last_str });
        }
        return list;
    }

    // 获取指定日期所在月
    public static int getMonthOfDate(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.MONTH);
    }

    // 获取指定年的最大周数
    public static int getMaxWeekNumOfYear(int year) {
        Calendar c = new GregorianCalendar();
        c.set(year, Calendar.DECEMBER, 31, 23, 59, 59);
        return getWeekOfYear(c.getTime());
    }

    // 获取指定日期所在月的最大周数
    public static int getMaxWeekNumOfMonth(Date date) {
        Calendar cal = new GregorianCalendar();
        cal.setFirstDayOfWeek(Calendar.MONDAY);//指定星期一作为一周第一天
        cal.setTime(date);
        int weekNumOfMonth = cal.getActualMaximum(Calendar.WEEK_OF_MONTH);
        //System.out.println(weekNumOfMonth);
        return weekNumOfMonth;
    }

    // 获取指定日期所在年的周数
    public static int getWeekOfYear(Date date) {
        Calendar c = new GregorianCalendar();
        c.setFirstDayOfWeek(Calendar.MONDAY);
       //c.setMinimalDaysInFirstWeek(7);
        c.setTime(date);
        return c.get(Calendar.WEEK_OF_YEAR);
    }

    //获取指定周第一天
    public static Date getFirstDayOfWeek(int year,int week) {
        Calendar cal = Calendar.getInstance();
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        cal.set(Calendar.YEAR,year);//设置年份
        cal.set(Calendar.WEEK_OF_YEAR, week); //设置周
        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        return cal.getTime();
    }

    ///获取指定周最后一天
    public static Date getLastDayOfWeek(int year, int week) {
        Calendar cal = new GregorianCalendar();
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        cal.set(Calendar.YEAR, year); //设置年份
        cal.set(Calendar.WEEK_OF_YEAR, week); //设置周
        cal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
        return cal.getTime();
    }

    //取得指定日期所在周的第一天
    public static Date getFirstDayOfWeek(Date date) {
        Calendar cal = new GregorianCalendar();
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        cal.setTime(date);
        cal.set(Calendar.DAY_OF_WEEK, cal.getFirstDayOfWeek()); // Monday
        return cal.getTime ();
    }

    //取得指定日期所在周的最后一天
    public static Date getLastDayOfWeek(Date date) {
        Calendar cal = new GregorianCalendar();
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        cal.setTime(date);
        cal.set(Calendar.DAY_OF_WEEK, cal.getFirstDayOfWeek() + 6); // Sunday
        return cal.getTime();
    }

}