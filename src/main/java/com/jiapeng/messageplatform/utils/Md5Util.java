package com.jiapeng.messageplatform.utils;


import java.net.URLEncoder;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;

/**
 * Created by ly on 2016/11/8.
 */
public class Md5Util {
    public final static String MD5(String inStr) {
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (Exception e) {
            System.out.println(e.toString());
            e.printStackTrace();
            return "";
        }
        char[] charArray = inStr.toCharArray();
        byte[] byteArray = new byte[charArray.length];

        for (int i = 0; i < charArray.length; i++)
            byteArray[i] = (byte) charArray[i];
        byte[] md5Bytes = md5.digest(byteArray);
        StringBuffer hexValue = new StringBuffer();
        for (int i = 0; i < md5Bytes.length; i++) {
            int val = ((int) md5Bytes[i]) & 0xff;
            if (val < 16)
                hexValue.append("0");
            hexValue.append(Integer.toHexString(val));
        }
        return hexValue.toString();
    }

    public static void main(String[] args) {
        System.out.print(MD5(URLEncoder.encode("小妹妹123")));
    }

    //对参数进行签名
    //◆参数名ASCII码从小到大排序（字典序）；
    //◆如果参数的值为空不参与签名；
    //◆参数名区分大小写；
    //◆验证调用返回或微信主动通知签名时，传送的sign参数不参与签名，将生成的签名与该sign值作校验。
    public static String generateSignature(final Map<String, Object> data, String key) {
        Set<String> keySet = data.keySet();
        String[] keyArray = keySet.toArray(new String[keySet.size()]);
        Arrays.sort(keyArray);
        StringBuilder sb = new StringBuilder();
        for (String k : keyArray) {
            if (k.equals("sign")) {
                continue;
            }
            Object value = data.get(k);
            if (null != value && value.toString().trim().length() > 0) // 参数值为空，则不参与签名
                sb.append(k).append("=").append(value.toString().trim()).append("&");
        }
        sb.append("key=").append(key);
        return MD5(sb.toString()).toUpperCase();
    }

}
