package top.dl.music.controller;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import top.dl.music.utils.StringUtil;

import java.io.IOException;
import java.util.HashMap;

/**
 * @author: minder
 * @createTime: 2023/09/25 19:21
 * @description:
 **/
@WebServlet("/context/*")
@Slf4j
public class ContextServletDemo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        String method = StringUtil.subUri(uri);
        switch (method) {
            case "demo1": {
                this.demo1(req,resp);
            }
            case "demo2" : {
                this.demo2(req,resp);
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
        }
    }

    //ServletContext对象获取
    private void demo1(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        //1.通过request对象获取
        ServletContext context1 = req.getServletContext();
        //2.通过HttpServlet获取
        ServletContext context2 = this.getServletContext();
        System.out.println(context1);
        System.out.println(context2);

        //true
        System.out.println(context1 == context2);
    }

    //ServletContext获取MIME类型
    private void demo2(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        /*ServletContext功能：
        * 1.获取MIME类型
        * MIME类型：在互联网通信过程中定义的一种文件数据类型
        * 格式： 大类型/小类型 text/html  image/jpeg
        * 获取 String getMimeType(String file)
        * 2.域对象：共享数据
        * 3.获取文件的真实服务器路径
        */

        //2.通过HttpServlet获取
        ServletContext context = this.getServletContext();

        //3.定义文件名称

        String filename = "bg.jpg";

        //4.获取MIME类型
        String mimeType = context.getMimeType(filename);
        System.out.println(mimeType);
    }

  //使用ServletContext作为域对象
    private void demo3(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        //通过HttpServlet获取
        ServletContext context = this.getServletContext();
        //设置数据
        context.setAttribute("msg","hello world");
    }

    private void demo4(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        //通过HttpServlet获取
        ServletContext context = this.getServletContext();
        //设置数据
        Object msg = context.getAttribute("msg");
        System.out.println(msg);
    }

    //使用ServletContext获取服务器路径
    private void demo5(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        //通过HttpServlet获取 ServletContext 对象
        ServletContext context = this.getServletContext();

        //webapp目录下的资源访问
        String b = context.getRealPath("/b.txt");
        System.out.println(b);

        //WEB-INF目录下的资源访问
        String c = context.getRealPath("/WEB-INF/c.txt");
        System.out.println(c);

        //resources 目录下的资源访问
        String a = context.getRealPath("/resources/a.txt");
        System.out.println(a);
    }
}
