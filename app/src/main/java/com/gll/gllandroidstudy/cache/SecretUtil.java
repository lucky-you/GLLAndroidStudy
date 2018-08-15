package com.gll.gllandroidstudy.cache;


import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * MD5加密工具类
 */

public class SecretUtil {

    //SecretUtil
    private static String NOSUCHALGORITHM = "不支持此种加密方式";
    private static String UNSUPPENCODING = "不支持的编码格式";

    /**
     * 传入字符串参数，返回MD5加密结果（小写）
     *
     * @param value 待加密的字符串
     * @return 加密结果
     */
    public static String getMD5Result(String value) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(value.getBytes("UTF-8"));
            byte[] result = md.digest();
            return getString(result);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return NOSUCHALGORITHM;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return UNSUPPENCODING;
        }
    }

    private static String getString(byte[] result) {
        StringBuilder sb = new StringBuilder();
        for (byte b : result) {
            int i = b & 0xff;
            if (i <= 0xf) {
                sb.append(0);
            }
            sb.append(Integer.toHexString(i));
        }
        return sb.toString().toLowerCase();
    }
}
