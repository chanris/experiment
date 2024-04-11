package com.chenyue.experiment.basic.util;

import java.io.*;
import java.security.MessageDigest;

/**
 * @author chenyue7@foxmail.com
 * @date 2021/3/6
 */
public class SHA512Test {
    public static void main(String[] args) throws IOException {
        File f = new File("F:\\IDEA workspace\\experiment\\src\\main\\resources\\apache-tomcat-9.0.43.zip");
        System.out.println(f.length());
        byte[] bytes = new byte[(int) f.length()];
        if (f.exists() && f.length() != 0) {
            FileInputStream in = new FileInputStream(f);
            System.out.println(in.read(bytes));
        }
        String mdCode = SHA512(new String(bytes));
        System.out.println(mdCode);
    }

    private static String SHA(final String strText, final  String strType) {
        String strResult = null;
        if (strText != null && strText.length() > 0) {
            try {
                // SHA加密开始 传入加密类型
                MessageDigest messageDigest = MessageDigest.getInstance(strType);
                // 传入加密的要字符串
                messageDigest.update(strText.getBytes());
                // 得到加密结果
                byte[] bytes = messageDigest.digest();
                StringBuilder strHexString = new StringBuilder();
                for (int i = 0; i < bytes.length; i++) {
                    String hex = Integer.toHexString(0xff & bytes[i]);
                    if (hex.length() == 1) {
                        strHexString.append('0');
                    }
                    strHexString.append(hex);
                    strResult = strHexString.toString();
                }
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
        return strResult;
    }


    public static String SHA512(final String strText) {
        return SHA(strText,"SHA-512");
    }
}
