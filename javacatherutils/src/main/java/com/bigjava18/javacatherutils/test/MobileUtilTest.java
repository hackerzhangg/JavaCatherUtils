package com.bigjava18.javacatherutils.test;

import com.bigjava18.javacatherutils.utils.MobileUtil;
import org.junit.Test;

/**
 * @Author zgp
 * @Since 2021 -09 -07 09 :28
 * @Description
 */
public class MobileUtilTest {

    @Test
    public void mobileUtilTest(){
        String hiddenMobile = MobileUtil.hiddenMobile("19979405395");
        System.out.println("hiddenMobile = " + hiddenMobile);
    }
}
