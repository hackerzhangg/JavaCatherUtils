package com.bigjava18.javacatherutils.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * @Author zgp
 * @Since 2021 -09 -06 16 :24
 * @Description 时间工具类
 */
public class TimeUtil {

    private static final TimeZone b = TimeZone.getTimeZone("Asia/Shanghai");

    /**
     *计算当天剩余的时间
     * @return
     */
    public static Integer getRemainSecondsOneDay() {
        Date currentDate = new Date();
        Calendar midnight = Calendar.getInstance();
        midnight.setTime(currentDate);
        midnight.add(Calendar.DAY_OF_MONTH, 1);
        midnight.set(Calendar.HOUR_OF_DAY, 0);
        midnight.set(Calendar.MINUTE, 0);
        midnight.set(Calendar.SECOND, 0);
        midnight.set(Calendar.MILLISECOND, 0);
        Integer seconds = (int) ((midnight.getTime().getTime() - currentDate.getTime()) / 1000);
        return seconds;
    }

    /**
     * 获取当前月份天数
     * @return
     */
    public static Integer getMonthDays() {
        Calendar a = Calendar.getInstance();
        //把日期设置为当月第一天du  
        a.set(Calendar.DATE,1);
        //日期回滚一天，也就是最后一天  
        a.roll(Calendar.DATE,-1);
        int maxDate = a.get(Calendar.DATE);
        System.err.println(maxDate);
        return maxDate;
    }

    /**
     * 计算当天几点剩余秒数
     * @param hour
     * @return
     */
    public static Integer getRemainSecondsHour(Integer hour) {
        Date currentDate = new Date();
        Calendar midnight = Calendar.getInstance();
        midnight.setTime(currentDate);
        midnight.add(Calendar.DAY_OF_MONTH, 1);
        midnight.set(Calendar.HOUR_OF_DAY, hour);
        midnight.set(Calendar.MINUTE, 0);
        midnight.set(Calendar.SECOND, 0);
        midnight.set(Calendar.MILLISECOND, 0);
        Integer seconds = (int) ((midnight.getTime().getTime() - currentDate.getTime()) / 1000);
        return seconds;
    }

    /**
     * 获取当天凌晨时间
     * @return
     */
    public static String nowDayZero(){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        Date zero = calendar.getTime();
        return dateToString(zero, "yyyy-MM-dd HH:mm:ss");
    }

    public static String dateToString(Date var0, String var1) {
        String var2 = "";
        SimpleDateFormat var3 = new SimpleDateFormat(var1);
        var3.setTimeZone(b);
        try {
            var2 = var3.format(var0);
        } catch (Exception var5) {
        }
        return var2;
    }

}
