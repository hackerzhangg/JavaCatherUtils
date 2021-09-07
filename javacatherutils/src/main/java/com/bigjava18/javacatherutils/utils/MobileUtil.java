package com.bigjava18.javacatherutils.utils;

import org.apache.commons.lang.StringUtils;
import java.util.Arrays;
import java.util.List;
import static com.sun.javafx.util.Utils.split;

/**
 * @Author zgp
 * @Since 2021 -09 -07 09 :22
 * @Description 隐藏手机号中间4位工具类
 */
public class MobileUtil {

    /**
     * 隐藏手机中间4位
     * @param mobile
     * @return
     */
    public static String hiddenMobile(String mobile) {
        String mobileTemp = "";
        if (StringUtils.isNotEmpty(mobile)) {
            List<String> mobileList = toStringList(mobile, ",");
            if (null != mobileList && mobileList.size() > 0) {
                mobileTemp += mobileList.get(0).substring(0, 3) + "****"
                        + mobileList.get(0).substring(7, mobileList.get(0).length());
                if (mobileList.size() > 1) {
                    for (int i = 1; i < mobileList.size(); i++) {
                        mobileTemp += "," + mobileList.get(i).substring(0, 3) + "****"
                                + mobileList.get(i).substring(7, mobileList.get(i).length());
                    }
                }
            }
            return mobileTemp;
        }
        return mobileTemp;
    }

    /**
     * 将String类型变量转换成List集合
     * @param var0
     * @param var1
     * @return
     */
    public static List<String> toStringList(String var0, String var1) {
        String[] var2 = split(var0, var1);
        return Arrays.asList(var2);
    }
}
