package com.chenyue.experiment.basic;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author chenyue7@foxmail.com
 * @date 2022/1/17 0:15
 * 位运算
 * &
 * |
 * ^
 * ~
 * << 左移 相当于乘2
 * >> 右移 相对除2
 * >>
 * >>> 无符号右移 高位补零(包括符号位)
 */
public class OperateTest {

    static String value;

    // 静态初始化块不能访问非静态属性和方法
    static {
        value = "NAME_CHEN";
    }

    /**
     * 如果没写构造器，则程序默认生成无参构造器，
     * 如果写了有参构造器, 则程序不生成无参构造器。
     * 访问控制符 public default protect private
     * public 任何包任何对象内都可以通过 object.xxx() 访问
     * default 同一包或者子包内的对象 可以通过 object.xxx() 访问
     * protect 本类或者子类内 可以通过 object.xxx() 访问
     * private 只允许在本类内访问
     *
     * 构造方法 constructor
     * 格式：
     * [限定符] 构造名称(形参列表) {
     *     构造体;
     * }
     *
     */
    public OperateTest() {
        int[] arr = new int[] {1, 2, 3, 4};
        int[] arr2 = new int[10];
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
   /*     for(int i = 1; i <= 9; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j+"*"+i+"="+i*j+"\t");
            }
            System.out.println();
        }

        int a = 3;
        {
            // int a = 3; 编译错误 不能定义重复的变量名。
            // 语句块内可以使用外部的变量，但是外部的代码不能使用内部定义的变量。
            // 语句块内定义的变量，只属于语句块内。
            System.out.println(factorial(4));
        }*/
        int[] arr = new int[] {1, 2, 3, 4};
        int[] arr2 = new int[10];
        System.out.println(Arrays.toString(arr));
    }


    /**
     * switch ()
     * {
     *     case 值1:
     *     //语句
     *     break;
     *     case 值2:
     *     //语句
     *     break;
     *     default:
     *     //语句
     * }
     *
     * // 布尔表达式为true执行循环体； 为false则跳出循环
     * while(布尔表达式)
     * {
     *     循环体;
     * }
     *
     * do {}while() 先执行一次，然后判断，若为true回来继续执行，若为false则跳出循环。
     *
     * for(初始语句; 判断语句; 循环体最后一句) {
     *     循环体;
     * }
     * f(;;){} =while(true){}死循环
     *
     * break &continue 用来控制循环体
     * break; 跳一层循环
     * continue; 终止某次循环，跳过循环体中尚未执行的代码，进行下一次循环。
     * java中方法调用传递参数都是值传递原则(传的都是数据的副本)。
     * 基本数据类型传的值的副本。
     * 对象类型传递的对象引用的副本，但指向同一个对象。
     *
     *
     * 方法的重载  ： 方法名称相同，参数个数，类型，顺序不同
     * 注意：只有返回值不同是不构成重载的。
     *
     * void methodName(String name, Integer id) ==> methodName_String_Integer
     * 对象及其子类 instanceof 类 返回true或者false
     *
     *
     * 重写 override
     * 1. '==' 方法名和形参列表一致
     * 2. '<=' 返回值类型和声明异常类型，子类小于等于父类。
     * 3. '>=' 访问权限,子类大于等于父类。
     *
     *
     * super关键字用来调用父类被覆盖或重写的属性和方法
     * super() 调用父类的无参构造器
     *
     * 多态的三个条件
     * 继承，重写， 父引用
     *
     *
     * java中的数组长度时确定的
     * 数组也是对象
     */


    /**
     *递归的缺点
     * 简单的程序是递归的优点之一。但是递归会调用大量的系统堆栈，内存消耗多，
     * 在递归调用层次多时速度要比循环慢的多，所以在使用递归时要慎重。
     */
    static int factorial(int n) {
        if (n == 1) {
            return 1;
        }else {
            return n * factorial(n-1);
        }
    }

    /**
     * java内存分析
     *
     * java内存分为三大部分：堆(heap)，栈(stack),方法区(method area)
     *
     * 栈的特点
     * 1.栈描述的是方法执行的内存模型每个方法被调用都会创建一个栈帧，每个方法被调用都会创建一个栈帧(存储局部变量，操作数，方法出口)
     * 2.jvm为每一个线程创建一个栈，用于存放该线程执行方法的信息（实际参数，局部变量等）
     * 3.栈属于线程私有，不能实现线程间共享
     * 4.栈的存储特性是FILO 先进后出
     * 5.栈是由系统自动分配，速度快！栈是一个连续的内存空间。
     * 堆的特点
     * 1.堆用于存储创建好的对象和数组
     * 2.jvm只有一个堆，被所有线程共享
     * 3.一不连续的内存空间。
     * 方法区(又叫静态区)
     * 1.jvm只有一个方法区，被所有线程共享
     * 2.方法区实际也是堆，只是用于存储类，常量相关的信息
     * 3.用于存放程序中不变，唯一的内容，class对象，比如静态变量，字符串常量等。
     */

    /**
     * 垃圾回收(GC)
     * 1. 找到无用的对象
     * 2. 回收无用对象相关的内存
     *
     * 找到无用的对象算法
     * 1.引用计数法：找该对象的引用，找到一个引用加1，引用变量值变为null时减一， 当引用个数为0时，则为无用对象。
     * 2.引用可达法：基于图论的搜索算法
     */
}
