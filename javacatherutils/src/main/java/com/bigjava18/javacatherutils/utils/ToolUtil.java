package com.bigjava18.javacatherutils.utils;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author zgp
 * @Since 2021 -09 -06 11 :31
 * @Description 工具类
 */
public class ToolUtil {

    /**
     * 生成六位随机验证码
     * @return
     */
    public static int getRandomNum(){
        Random random=new Random();
        int randomNumber=random.nextInt(900000)+100000;
        return randomNumber;
    }

    /**
     * 验证邮箱是否合法
     * @param email
     * @return
     */
    public static boolean checkEmail(String email){
        boolean flag=false;
        try {
            String check = "^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
            Pattern regex=Pattern.compile(check);
            Matcher matcher=regex.matcher(email);
            flag=matcher.matches();
        }catch ( Exception e ){
            flag=false;
        }
        return flag;
    }

    /**
     * 验证手机号码是否合法
     * @param mobileNumber
     * @return
     */
    public static boolean checkMobileNumber(String mobileNumber){
        boolean flag=false;
        try {
            Pattern regex = Pattern.compile("^(((13[0-9])|(15([0-3]|[5-9]))|(18[0,5-9]))\\d{8})|(0\\d{2}-\\d{8})|(0\\d{3}-\\d{7})$");
            Matcher matcher=regex.matcher(mobileNumber);
            flag=matcher.matches();
        }catch ( Exception e ){
            flag=false;
        }
        return flag;
    }
}
