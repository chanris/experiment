package com.chenyue.tomcat.chapter2;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author chenyue7@foxmail.com
 * @date 2021/4/16
 *
 * servlet加载顺序
 * 1. init()方法 仅调用一次
 * 2. service()方法
 * 3. destroy() servlet被摧毁前调用
 *
 */
public class PrimitiveServlet implements Servlet {
    public void init(ServletConfig config) throws ServletException {
        System.out.println("init");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest req, ServletResponse response) throws ServletException, IOException {
        System.out.println("from service...");
        PrintWriter out = response.getWriter();
        String body = "<h1>This is my servlet container</h1>";
        String header = "HTTP/1.1 200 OK\r\n" +
                "Content-Type: text/html\r\n" +
                "Content-Length: "+ body.getBytes().length + "\r\n" + /*单位byte*/
                "\r\n" ;
        out.print(header);
        out.println(body);
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
