package com.bigjava18.javacatherutils.test;

import com.bigjava18.javacatherutils.utils.TimeUtil;
import org.junit.Test;

/**
 * @Author zgp
 * @Since 2021 -09 -06 16 :26
 * @Description
 */
public class TimeUtilTest {

    @Test
    public void getRemainSecondsOneDayTest(){
        Integer remainSecondsOneDay = TimeUtil.getRemainSecondsOneDay();
        System.out.println("remainSecondsOneDay = " + remainSecondsOneDay);
    }

    @Test
    public void getMonthDaysTest(){
        Integer monthDays = TimeUtil.getMonthDays();
        System.out.println("monthDays = " + monthDays);
    }

    @Test
    public void getRemainSecondsHourTest(){
        Integer remainSecondsHour = TimeUtil.getRemainSecondsHour(9);
        System.out.println("remainSecondsHour = " + remainSecondsHour);
    }

    @Test
    public void nowDayZeroTest(){
        String nowDayZero = TimeUtil.nowDayZero();
        System.out.println("nowDayZero = " + nowDayZero);
    }
}
