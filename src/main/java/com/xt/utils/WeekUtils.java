package com.xt.utils;

/**
 * @Author Winter
 * @Date 2019/12/11 8:32
 * 前台接收的周为数字0-6 改为星期几 0为星期天
 */
public class WeekUtils {
    public static String getWeek(int week){
        String day = "";
        switch (week){
            case 0:
                day += "星期天";
                break;
            case 1:
                day += "星期一";
                break;
            case 2:
                day += "星期二";
                break;
            case 3:
                day += "星期三";
                break;
            case 4:
                day += "星期四";
                break;
            case 5:
                day += "星期五";
                break;
            case 6:
                day += "星期六";
                break;
        }
        System.out.println(day);
        return day;
    }
}
