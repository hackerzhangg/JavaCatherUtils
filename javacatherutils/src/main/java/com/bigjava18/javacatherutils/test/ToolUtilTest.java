package com.bigjava18.javacatherutils.test;

import com.bigjava18.javacatherutils.utils.ToolUtil;
import org.junit.Test;

/**
 * @Author zgp
 * @Since 2021 -09 -06 11 :34
 * @Description 工具类测试类
 */
public class ToolUtilTest {

    @Test
    public void getRandomNumTest(){
        int randomNum = ToolUtil.getRandomNum();
        System.out.println("randomNum = " + randomNum);
    }

    @Test
    public void checkEmailTest(){
        boolean checkEmailBoolean = ToolUtil.checkEmail("2088220905@qq.com");
        if (checkEmailBoolean)
            System.out.println("checkEmailBoolean = " + checkEmailBoolean);
        else
            System.out.println("checkEmailBoolean = " + checkEmailBoolean);
    }

    @Test
    public void checkMobileNumberTest(){
        boolean checkMobileNumberBoolean = ToolUtil.checkMobileNumber("19979405395");
        if (checkMobileNumberBoolean)
            System.out.println("checkMobileNumberBoolean = " + checkMobileNumberBoolean);
        else
            System.out.println("checkMobileNumberBoolean = " + checkMobileNumberBoolean);
    }

}
