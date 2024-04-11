package com.chenyue.experiment.regex;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author chenyue7@foxmail.com
 * @date 2021/3/15
 */
public class PatternTest {
    public static void main(String[] args) {
//        Pattern pattern = Pattern.compile("\\d+");  // regex的java写法，这样写是为了符合java语法
        Pattern pattern = Pattern.compile("\\s+");
        System.out.println(pattern.pattern()); // 返回regex参数
        String[] str = pattern.split("我的QQ是:456456我的电话是:0532214我的邮箱是:aaa@aaa.com");
        str = pattern.split("我的QQ是:   我的电话是:     我的邮箱是:aaa@aaa.com");
        System.out.println(Arrays.toString(str));

        //Pattern.matcher(String regex,CharSequence input)是一个静态方法,用于快速匹配字符串,该方法适合用于只匹配一次,且匹配全部字符串.
        boolean matches = Pattern.matches("\\d+", "12");
        System.out.println(matches);

        Pattern p2 = Pattern.compile("\\d+");
        Matcher matcher = p2.matcher("aa11aa22bb33bbSAsA");
        Pattern p3 = matcher.pattern();// 返回创建matcher的pattern
        System.out.println(p2 == p3);
        System.out.println("lookingAt: " + matcher.lookingAt()); //从整个字符串开始匹配 没匹配到就false
        System.out.println("find: " + matcher.find()); // 从字符串任意位置开始匹配 只要存在一个就true
        System.out.println("find index: " + matcher.find(12)); // 从指定index开始找后面的子字符串匹配 只要存在一个就true
        System.out.println(matcher.matches()); // 返回false因为不能匹配整个字符串
        Matcher matcher1 = p2.matcher("112233");
        System.out.println(matcher1.matches()); // 返回true因为不能匹配整个字符串

    }
}
