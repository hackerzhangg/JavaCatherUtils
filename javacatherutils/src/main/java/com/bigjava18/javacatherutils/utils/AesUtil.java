package com.bigjava18.javacatherutils.utils;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/**
 * @Author zgp
 * @Since 2021 -09 -06 16 :57
 * @Description Aes加密解密工具类
 */
public class AesUtil {

    /**
     * AES解密 用于数据库储存
     * @param sSrc
     * @param key
     * @return
     */
    public static String decrypt(String sSrc, String key) {
        String sKey = secureBytes(key);
        int numberValue = 16;
        try {
            // 判断Key是否正确
            if (sKey == null) {
                return null;
            }
            // 判断Key是否为16位
            if (sKey.length() != numberValue) {
                System.out.println("长度不是16");
                sKey = secureBytes(sKey);
            }
            byte[] raw = sKey.getBytes("ASCII");
            SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, skeySpec);
            byte[] encrypted1 = hex2byte(sSrc);
            try {
                byte[] original = cipher.doFinal(encrypted1);

                String originalString = new String(original, "utf-8");
                return originalString;
            } catch (Exception e) {
                return null;
            }
        } catch (Exception ex) {
            return null;
        }
    }

    /**
     * 密钥如超过16位，截至16位，不足16位，补/000至16位
     * @param key
     * @return
     */
    public static String secureBytes(String key) {
        int shiliu = 16;
        int shiwu = 15;
        if (key.length() > shiliu) {
            key = key.substring(0, 16);
        } else if (key.length() < shiliu) {
            StringBuffer buffer2 = new StringBuffer();
            buffer2.append(key);
            for (int i = (key.length() - 1); i < shiwu; i++) {
                buffer2.append("\000");
            }
            key = buffer2.toString();
        }
        return key;
    }

    public static byte[] hex2byte(String strhex) {
        int er = 2;
        if (strhex == null) {
            return null;
        }
        int l = strhex.length();
        if (l % er != 0) {
            return null;
        }
        byte[] b = new byte[l / 2];
        for (int i = 0; i != l / er; i++) {
            b[i] = (byte) Integer.parseInt(strhex.substring(i * 2, i * 2 + 2),
                    16);
        }
        return b;
    }

    /**
     * 用户生成aesKey
     * @param args
     */
    public static void main (String[] args){
        int len = 16;
        int f =0;
        char[] pwd = new char[len];
        for(int i = 0 ; i<len;i++){
            //随机生成0，1，2三个数中的一个f，作为判断条件
            f = (int)(Math.random()*3);
            if(f==0){
                //生成0-9之间的随机数字
                pwd[i] = (char)('0'+Math.random()*10);
            }else if(f==1){
                //随机生成一个小写字母
                pwd[i] = (char)('a'+ Math.random()*26);
            }else
                //随机生成一个大写字母
                pwd[i] =(char)('A'+Math.random()*26);
        }
        String str = new String(pwd);
        System.out.print(str);
    }

    /**
     * 生成加密key
     * @return
     */
    public static String getAesKey(){
        int len = 16;
        int f =0;
        char[] pwd = new char[len];
        for(int i = 0 ; i<len;i++){
            //随机生成0，1，2三个数中的一个f，作为判断条件
            f = (int)(Math.random()*3);
            if(f==0){
                //生成0-9之间的随机数字
                pwd[i] = (char)('0'+Math.random()*10);
            }else if(f==1){
                //随机生成一个小写字母
                pwd[i] = (char)('a'+ Math.random()*26);
            }else
                //随机生成一个大写字母
                pwd[i] =(char)('A'+Math.random()*26);
        }
        String str = new String(pwd);
        return str;
    }

    /**
     * aes加密
     * @param sSrc
     * @param key
     * @return
     */
    public static String encrypt(String sSrc, String key) {
        int numberValue = 16;
        String sKey = secureBytes(key);
        try {
            if (sSrc == null || sKey == null) {
                return null;
            }
            // 判断Key是否为16位
            if (sKey.length() != numberValue) {
                sKey = secureBytes(sKey);
            }
            byte[] raw = sKey.getBytes("ASCII");
            SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
            byte[] encrypted = cipher.doFinal(sSrc.getBytes());
            return byte2hex(encrypted).toLowerCase();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
    }

    public static String byte2hex(byte[] b) {
        StringBuilder hs = new StringBuilder();
        String stmp = "";
        for (int n = 0; n < b.length; n++) {
            stmp = (Integer.toHexString(b[n] & 0XFF));
            if (stmp.length() == 1) {
                hs.append("0" + stmp);
            } else {
                hs.append(stmp);
            }
        }
        return hs.toString().toUpperCase();
    }
}
