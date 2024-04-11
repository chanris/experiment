package com.chenyue.experiment.basic;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * @author chenyue7@foxmail.com
 * https://blog.csdn.net/haiyinshushe/article/details/82721234
 */
/*
java 基本数据类型 primitive type & reference type
类型    存储字节   范围            默认值   包装类
int     4         -2^31~2^31-1    0       Integer
short   2         -2^15~2^15-1    0       Short
byte    1         -2^7~2^7-1      0       Byte
char    2         \u0000~\uffff
*/
/*
* BigDecimal
* BigDecimal num = new BigDecimal("0.005"); 尽量使用字符串初始化
* 使用double类型值初始化BigDecimal，由于不是所有浮点数都能精确的表示成一个double类型值，
* 有些浮点数值不能够被精确的表示成double类型值，因此它会被表示成与它最接近的double类型的值
* 。所有<p>所以必须使用String的构造方法</p>
* */
/*
科学计数法： 符号:尾数:指数
尾数: 指大小在1<x<10之间的数
指数: 指十的几次方
eg: 3140的科学计数表示==>3.14*10^3
 */
/*
java 浮点型详解
float  单精度浮点型  1bit(符号位) 8bit(指数位)   23(尾数位)
double 双精度浮点型  1bit(符号位) 11bit(指数位)  52(尾数位)



 */
public class BaseTypeTest {

    /**
     * boolean 类型没有提供size方法
     */
    public static void calTypeBytes(){
        System.out.println("char: " + Character.BYTES);
        System.out.println("byte: " + Byte.BYTES);
        System.out.println("short: " + Short.BYTES);
        System.out.println("int: " + Integer.BYTES);
        System.out.println("long: " + Long.BYTES);
        System.out.println("float: " + Float.BYTES);
        System.out.println("double: " + Double.BYTES);
        System.out.println("boolean: 没有size方法");
    }


    public static void bigDecimalTest(){
        BigDecimal num = new BigDecimal("1.2");
        BigDecimal num2 = new BigDecimal("1.3");

        //使用decimal除法时要设置三个参数，
        // (BigDecimal divide 除数, int scale 精确小数位, int roundingMode 舍入模式 )
        System.out.println(num.divide(num2, 10, RoundingMode.HALF_EVEN)); // 四舍六入 五分两种情况
        // 乘法
        System.out.println(num.multiply(num2));
        // 加分
        System.out.println(num.add(num2));
        // 减法
        System.out.println(num.subtract(num2));
    }

    public static void main(String[] args) {
        //calTypeBytes();
        //bigDecimalTest();
//        System.out.println(12f - 11.9f);
    }
}
