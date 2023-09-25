package top.dl.music.controller;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import top.dl.music.utils.StringUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

/**
 * @author: minder
 * @createTime: 2023/09/25 17:11
 * @description:
 **/
@WebServlet("/request/*")
@Slf4j
public class RequestServletDemo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //get获取请求参数
        //根据参数名称获取参数值
        this.doPost(req, resp);
        String username = req.getParameter("username");
        System.out.println(username);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        String method = StringUtil.subUri(uri);
        switch (method) {
            case "demo1": {
                this.demo1(req, resp);
            }
            case "demo2": {
                this.demo2(req, resp);
            }
            case "demo3": {
                this.demo3(req, resp);
            }
            case "demo4": {
                this.demo4(req, resp);
            }
            case "demo5": {
                this.demo5(req, resp);
            }
            case "demo6": {
                this.demo6(req, resp);
            }
            case "demo7": {
                this.demo7(req, resp);
            }
            case "demo8": {
                this.demo8(req, resp);
            }
            case "demo9": {
                this.demo9(req, resp);
            }
        }
    }


    private void demo1(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        resp.setHeader("content-type", "text/html;charset=UTF-8");
        String method = req.getMethod();
        log.info(method);
        String contextPath = req.getContextPath();
        log.info(contextPath);
        String queryString = req.getQueryString();
        if (queryString != null) {
            log.info(queryString);
            String[] s = queryString.split("&");
            log.info(s[0]);
            log.info(s[1]);

        }
        resp.getWriter().println("请求方式：" + method + "<br/>");
    }

    private void demo2(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求头数据
        //1.获取所有请求头名称
        Enumeration<String> headerNames = req.getHeaderNames();
        //2.遍历
        while (headerNames.hasMoreElements()) {
            String name = headerNames.nextElement();
            //根据名称获取请求头的值
            String value = req.getHeader(name);
            System.out.println(name + "---" + value);
        }
    }

    private void demo3(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求头数据：user-agent
        String agent = req.getHeader("user-agent");
        //判断agent的浏览器版本
        if (agent.contains("Chrome")) {
            System.out.println("谷歌浏览器...");
        } else if (agent.contains("Firefox")) {
            System.out.println("火狐浏览器...");
        }
    }

    private void demo4(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求消息体--请求参数
        //1.获取字符流
        BufferedReader br = req.getReader();
        //2.读取数据
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
    }

    private void demo5(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //post 获取请求参数
        //根据参数名称获取参数值
        System.out.println("根据参数名称获取参数值");
        String username = req.getParameter("username");
        System.out.println(username);
        //根据参数名称获取参数值的数组
        String[] hobbies = req.getParameterValues("hobby");
        for (String hobby :
                hobbies) {
            System.out.println(hobby);
        }
        //获取所有请求的参数名称
        System.out.println("***********************");
        System.out.println("获取所有请求的参数名称");
        Enumeration<String> parameterNames = req.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String name = parameterNames.nextElement();
            System.out.println(name);
            String value = req.getParameter(name);
            System.out.println(value);
            System.out.println("----------------");
        }
        //获取所有参数的map集合
        System.out.println("***********************");
        System.out.println("获取所有参数的map集合");
        Map<String, String[]> parameterMap = req.getParameterMap();
        //遍历
        Set<String> keySet = parameterMap.keySet();
        for (String name : keySet) {
            //获取键获取值
            String[] values = parameterMap.get(name);
            System.out.println(name);
            for (String value :
                    values) {
                System.out.println(value);
            }
            System.out.println("-----------------");
        }
    }

    private void demo6(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String username = req.getParameter("username");
        System.out.println(username);
    }

    private void demo7(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("demo7被访问了...");
        //存储数据到request域中
        req.setAttribute("msg", "hello~ dl");
        //转发到demo7资源
        req.getRequestDispatcher("/request/demo8").forward(req, resp);
        //无法跨域转发
        //req.getRequestDispatcher("http://www.baidu.com").forward(req,resp);
    }

    private void demo8(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //从request域中获取数据
        Object msg = req.getAttribute("msg");
        System.out.println(msg);
        System.out.println("demo8被访问了....");

    }

    private void demo9(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext servletContext = req.getServletContext();
        System.out.println(servletContext);
    }
}
