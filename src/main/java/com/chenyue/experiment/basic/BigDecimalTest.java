package com.chenyue.experiment.basic;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author chenyue7@foxmail.com
 * @date 2024/7/10
 * @description 测试 BigDecimal类的使用与坑点
 *
 * 1.BigDecimal(double)构造器问题
 * 2.compareTo 和 equals方法的区别
 * 3.科学计数法问题
 */
public class BigDecimalTest {
    public static void main(String[] args) {
        // 【强制】创建BigDecimal不能使用 BigDecimal(double)构造器会有精度损失
        BigDecimal amount1 = new BigDecimal(0.1);
        System.out.println(amount1.toString());

        // 使用 valueOf 会对double、float精度做限制
        BigDecimal amount2 = BigDecimal.valueOf(0.1);
        System.out.println(amount2);

        // 推荐使用 BigDecimal(String)构造器
        BigDecimal amount3 = new BigDecimal("0.10");
        System.out.println(amount3);

        // equals 会比较值和精度，比如 0.1 == 0.10 为 false
        System.out.println(amount2.equals(amount3));
        // compareTo 只会比较值，比如 0.1 == 0.10 为 true
        System.out.println(amount2.compareTo(amount3) == 0);

        BigDecimal amount4 = BigDecimal.valueOf(123456789012345678.12345678236);
        System.out.println(amount4.toString()); // 默认toString使用科学计数法，当有效位太长会有科学计数法表示
        System.out.println(amount4.toPlainString());// 不使用科学计数法
        BigDecimal result = amount4.divide(amount2, 2, RoundingMode.HALF_UP);//除法需要指定精度规则 HALF_UP（四舍五入）
        System.out.println(result);
    }
}
