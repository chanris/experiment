package com.chenyue.experiment.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author chenyue7@foxmail.com
 *
 *
 * [abc]:或a或b或c
 * [^abc]:非a非b非c
 * [^a-zA-Z]:非字符
 *
 * 捕获组:
 * 例: 表达式 ((A)(B(c)))有四个组
 * 1. ((A)(B(C)))
 * 2. (A)
 * 3. (B(C))
 * 4. (C)
 *
 * 可以通过调用matcher对象的groupCount方法来查看表达式有几个组
 * 特殊组:group(0),它总是代表整个表达式, 该组不包括在groupCount中
 *
 *
 * \d: 表示匹配任意一个数字
 * \D: 匹配非数字
 * \\d: 实际需要\\d表示匹配任意一个数字,因为\表示转义所以需要\\d表示\d
 * \s: 匹配一个空白字符 比如 空格,\t,\b,\n
 * \S: 匹配非白字符
 * \w: 匹配单词字符, 包括0~9, a~b和A~Z和下划线 '_'
 * \W
 *
 * https://blog.csdn.net/qq_18298439/article/details/88974940
 */
public class RegxTest {

    public static void main(String[] args) {

//        Pattern pattern = Pattern.compile("\\d");
//        Matcher matcher = pattern.matcher("1");
//        String dateStr = null;
//        System.out.println(Pattern.matches("\\w", "O"));
//        System.out.println(matcher.find() ? matcher.group(0):null);
//        if (matcher.find()){
//            System.out.println(dateStr);
//            for (int i = 0; i < matcher.groupCount(); i++){
//                System.out.println(matcher.group(i));
//            }
//            System.out.println(matcher.groupCount());
//        }

        String str = "Alpha.Beta.Gamma.";
        for (String s : str.split("\\.\\s*")) {
            System.out.println(s);
        }


        boolean food = Pattern.matches("fo{2}d", "food");       // {2} 匹配指定个数的前一个
//        boolean food = Pattern.matches("fo*d", "fd"); // 匹配零个或者多个前一个字符串
//        boolean food = Pattern.matches("fo{0,2}d", "fd");
//        boolean food = Pattern.matches("fo{0,}d", "food"); // 相当于fo*d
//        boolean food = Pattern.matches("f(o)?d", "food"); // 匹配零次或者一次，相当于f(o){0,1}d
//        boolean food = Pattern.matches("f(.){0,2}d", "food"); //匹配除"\r\n"之外的任何单个字符。若要匹配包括"\r\n"在内的任意字符，请使用诸如"[\s\S]"之类的模式。
//        boolean food = Pattern.matches("fo{2}d", "food");
//        boolean food = Pattern.matches("food(?:s|yes|chen)", "foodches");
//        boolean food = Pattern.matches("food(?=yes|c)", "foodyes"); //TODO don't work
//        boolean food = Pattern.matches("fo([oy])d", "food");
//        boolean food = Pattern.matches("fo[^oy]d", "food");
//        boolean food = Pattern.matches("fo([a-zA-z0-9]){2}d", "foA2d");
//        boolean food = Pattern.matches("fo([a-z]){2}d\\b", "fosdd"); // '\\b'识别字符串边相邻的字符
//        boolean food = Pattern.matches("fo[o]d\\B", "food");  // '\\B'识别字符串边相邻的字符
//        boolean food = Pattern.matches("fo[^oy]\\dd", "foo1d"); //数字字符匹配。等效于 [0-9]。
//        boolean food = Pattern.matches("fo[oy]\\Dd", "foo!d"); //匹配非数字字符。等效于 [^0-9]。
//        boolean food = Pattern.matches("fo(\\s)*d", "fo  d"); //匹配任何个空白字符，包括空格、制表符、换页符等。与 [ \f\n\r\t\v] 等效。
//        boolean food = Pattern.matches("fo(\\S)*d", "food");  //\\S 匹配一个， 匹配任何个非空白字符，包括空格、制表符、换页符等。与 [ \f\n\r\t\v] 等效。
//        boolean food = Pattern.matches("fo\\wd", "food"); //匹配任何字类字符，包括下划线。与"[A-Za-z0-9_]"等效。
//        boolean food = Pattern.matches("fo\\Wd", "fo!d"); //匹配任何非字类字符，包括下划线。与"[^A-Za-z0-9_]"等效。
        System.out.println(food);
    }
}
