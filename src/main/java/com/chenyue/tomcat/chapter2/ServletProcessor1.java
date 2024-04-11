package com.chenyue.tomcat.chapter2;

import javax.servlet.Servlet;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLStreamHandler;

/**
 * @author chenyue7@foxmail.com
 * @date 2021/4/16
 * 处理servlet的HTTP请求
 */
public class ServletProcessor1 {
    public void process(Request request, Response response) {
        String uri = request.getUri();
        String servletName = uri.substring(uri.lastIndexOf("/") + 1);
        URLClassLoader loader = null;
        try {
            // create a URLClassLoader
            URL[] urls = new URL[1];
            URLStreamHandler streamHandler = null;
            File classPath = new File(Constants.WEB_CLASSES);
            // the forming of repository is taken from the
            // createClassLoader method in
            // org.apache.catalina.startup.ClassLoaderFactory
            // classPath.getCanonicalPath() 系统规范绝对路径
            String repository =(new URL("file", null, classPath.getCanonicalPath() +
                    File.separator)).toString() ;
            // the code for forming the URL is taken from
            // the addRepository method in
            // org.apache.catalina.loader.StandardClassLoader.
            urls[0] = new URL(null, repository, streamHandler);
            loader = new URLClassLoader(urls);
        } catch (IOException e) {
            System.out.println(e.toString() );
        }
        Class<?> myClass = null;
        try {
            myClass = loader.loadClass("com.chenyue.tomcat.chapter2."+servletName);
        } catch (ClassNotFoundException e) {
            System.out.println(e.toString());
        }
        Servlet servlet = null;
        try {
            // newInstance() 只能调用无参构造
            servlet = (PrimitiveServlet) myClass.newInstance();
            System.out.println(servlet != null);

            // !!
            // 向上转换 是父类， 但是也可以向下转 为 Request
            // 但这样危害安全性，因为Request有公共方法，而servlet容器不希望其他人随意调用它们。
            // 解决方法: 加上默认修饰符(去掉public)
            // 或者用更优雅的方式 facade类
            servlet.service((ServletRequest) request,
                    (ServletResponse) response);
        } catch (Exception e) {
            System.out.println(e.toString());
        } catch (Throwable e) {
            System.out.println(e.toString());
        }
    }
}
