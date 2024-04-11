package com.chenyue.experiment.basic;

/**
 * @author chenyue7@foxmail.com
 * @date 2021/3/9
 */
public class OsPropertyTest {
    public static void main(String[] args) {
        System.out.println(System.getProperty("java.io.tmpdir"));             // local缓存目录
        System.out.println(System.getProperty("java.version"));               // java版本号 (详细)
        System.out.println(System.getProperty("java.vendor"));                // Java运行时环境提供商
        System.out.println(System.getProperty("java.vendor.url"));            // Java运行时环境提供商的URl
        System.out.println(System.getProperty("java.home"));                  //Java安装路径
        System.out.println(System.getProperty("java.specification.version")); //java虚拟机规范版本
        System.out.println(System.getProperty("java.specification.vendor"));  //java虚拟机规范提供商
        System.out.println(System.getProperty("java.specification.name"));    //java虚拟机实现名称
        System.out.println(System.getProperty("java.class.version"));         //Java类格式版本号
        System.out.println(System.getProperty("java.class.path"));            //Java类路径
        System.out.println(System.getProperty("java.library.path"));          //加载库时搜索的路径列表
        System.out.println(System.getProperty("java.compiler"));              //使用的JIT编译器名称
        System.out.println(System.getProperty("java.ext.dirs"));              //一个或者多个扩展目录的路径
        System.out.println(System.getProperty("os.name"));                    //操作系统的名称
        System.out.println(System.getProperty("os.arch"));                    //操作系统的架构
        System.out.println(System.getProperty("os.version"));                 //操作系统的版本
        System.out.println(System.getProperty("file.separator"));             //文件分隔符 在UNIX是"/"
        System.out.println(System.getProperty("path.separator"));             //路径分隔符 在UNIX是":"
        System.out.println(System.getProperty("line.separator"));             //行分隔符 在UNIX是"/n"
        System.out.println(System.getProperty("user.name"));                  //用户的账户名称
        System.out.println(System.getProperty("user.home"));                  //用户的主目录
        System.out.println(System.getProperty("user.dir"));                   //用户的工作目录
    }
}
