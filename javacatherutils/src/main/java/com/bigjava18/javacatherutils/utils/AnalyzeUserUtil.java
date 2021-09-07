package com.bigjava18.javacatherutils.utils;

import org.apache.commons.lang.StringUtils;

import java.util.Calendar;
import java.util.Date;

/**
 * @Author zgp
 * @Since 2021 -09 -07 09 :37
 * @Description 分析用户工具类
 */
public class AnalyzeUserUtil {

    private static final int FIFTEEN = 15;
    private static final int TWO = 2;

    /**
     * 判断身份证号码是男或女
     * @param idCard
     * @return
     */
    public static Integer getSexValue(String idCard){
        if (StringUtils.isEmpty(idCard)) {
            //身份证号码为空
            return 0;
        }
        String sexStr = "";
        if (idCard.length()==FIFTEEN) {
            //15位看倒数第一位
            sexStr = idCard.substring(14, 15);
        }else {
            //18位看倒数第二位
            sexStr = idCard.substring(16, 17);
        }
        Integer sexInt = Integer.valueOf(sexStr);
        if (sexInt % TWO ==0) {
            //女
            return 2;
        }else {
            return 1;
        }
    }

    /**
     * 通过身份证号码获取年龄
     * @param idCard
     * @return
     */
    public static Integer getAgeValue(String idCard){
        if (StringUtils.isEmpty(idCard)) {
            //身份证号码为空
            return 0;
        }
        String bornYearStr = idCard.substring(6, 10);
        Integer bornYearInt = Integer.valueOf(bornYearStr);
        Integer currentYear = getYear(new Date());
        Integer age = currentYear - bornYearInt +1;
        return age;
    }

    /**
     * 获取年
     * @param var0
     * @return
     */
    public static int getYear(Date var0) {
        Calendar var1 = Calendar.getInstance();
        var1.setTime(var0);
        return var1.get(1);
    }
}
