package com.gll.gllandroidstudy.utils;

import java.util.Calendar;
import java.util.TimeZone;

/**
 * author      : Z_B
 * date       : 2018/11/27
 * function  :
 */
public class SelectYearDateUtils {



    //获取当前时间
    public static Calendar startCalendar() {
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT+08:00"));    //获取东八区时间
        int year = calendar.get(Calendar.YEAR) - 60;    //获取年,当前年份-60年
        int month = calendar.get(Calendar.MONTH);   //获取月份，0表示1月份
        int day = calendar.get(Calendar.DAY_OF_MONTH);    //获取当前天数
        int hour = calendar.get(Calendar.HOUR_OF_DAY);       //获取当前小时
        int minute = calendar.get(Calendar.MINUTE);          //获取当前分钟
        calendar.set(year, month, day, hour, minute);
        return calendar;

    }

    //获取结束时间,
    public static Calendar endCalendar() {
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT+08:00"));    //获取东八区时间
        int year = calendar.get(Calendar.YEAR);    //获取年,当前年份
        int month = calendar.get(Calendar.MONTH);   //获取月份，0表示1月份
        int day = calendar.get(Calendar.DAY_OF_MONTH);    //获取当前天数
        int hour = calendar.get(Calendar.HOUR_OF_DAY);       //获取当前小时
        int minute = calendar.get(Calendar.MINUTE);          //获取当前分钟
        calendar.set(year, month, day, hour, minute);
        return calendar;
    }
}
