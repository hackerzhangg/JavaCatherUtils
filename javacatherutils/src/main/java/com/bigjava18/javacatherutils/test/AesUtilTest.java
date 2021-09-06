package com.bigjava18.javacatherutils.test;

import com.bigjava18.javacatherutils.constant.AesConstant;
import com.bigjava18.javacatherutils.utils.AesUtil;
import org.junit.Test;

/**
 * @Author zgp
 * @Since 2021 -09 -06 17 :07
 * @Description
 */
public class AesUtilTest {

    /**
     * 利用aes对数据进行加密
     */
    @Test
    public void encryptionValue(){
        //对数据进行aes加密
        String encryptValue = AesUtil.encrypt("bb", AesConstant.AES_KEY);
        //对数据进行解密操作
        String decryptValue = AesUtil.decrypt(encryptValue, AesConstant.AES_KEY);
        System.out.println("decryptValue = " + decryptValue);
    }

    /**
     * 利用aes对数据进行解密
     */
    @Test
    public void decryptValue(){
        //加密字符串
        String decryptData="4ec62b250405a32369e2f589c1075052";
        //解密字符串操作
        String decrypt = AesUtil.decrypt(decryptData, AesConstant.AES_KEY);
        System.out.println("decrypt = " + decrypt);
    }

    /**
     * 生成aes密钥
     */
    @Test
    public void getAesKey(){
        String aesKey = AesUtil.getAesKey();
        System.out.println("aesKey = " + aesKey);
    }
}
