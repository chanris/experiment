package com.chenyue.experiment.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author chenyue7@foxmail.com
 * @date 2021/2/28
 */
public class EmailFormatChecker {
    public void checkEmail(String src) {
        // ^表示开头需要匹配的字符
        Pattern p = Pattern.compile("^\\.|^@");
        Matcher m = p.matcher(src);
        if (m.find()) {
            System.out.println("EMAIL地址不能以'.'或者'@'开头");
        }
        p = Pattern.compile("^www\\.");
        m = p.matcher(src);
        if (m.find()) {
            System.out.println("EMAIL地址不能以'www.'开头");
        }
        p = Pattern.compile("[A-Za-z0-9.@_\\-~#]+");
        m = p.matcher(src);
        StringBuilder sb = new StringBuilder();
        boolean result = m.find();
        boolean deletedIllegalChars = false;
        while (result) {
            deletedIllegalChars = true;
            m.appendReplacement(sb,"");
            result = m.find();
        }
        m.appendTail(sb);
        String target = sb.toString();
        if (deletedIllegalChars) {
            System.out.println("输入的EMAIL地址里包含有冒号、逗号等非法字符，请修改");
            System.out.println("您现在的输入为: "+src);
            System.out.println("修改后合法的地址应类似: "+target);
        }
    }

    public static void main(String[] args) {
        EmailFormatChecker checker = new EmailFormatChecker();
        String email = "2511006757@qq.com";
        checker.checkEmail(email);
    }
}
