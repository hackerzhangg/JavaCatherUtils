package com.bigjava18.javacatherutils.test;

import com.bigjava18.javacatherutils.utils.AnalyzeUserUtil;
import org.junit.Test;

/**
 * @Author zgp
 * @Since 2021 -09 -07 09 :41
 * @Description
 */
public class AnalyzeUserUtilTest {

    @Test
    public void analyzeUserUtilTest(){
        Integer sexValue = AnalyzeUserUtil.getSexValue("360681197906202644");
        System.out.println("sexValue = " + sexValue);
    }

    @Test
    public void getAgeValueTest(){
        Integer ageValue = AnalyzeUserUtil.getAgeValue("360681197906202644");
        System.out.println("ageValue = " + ageValue);
    }
}
