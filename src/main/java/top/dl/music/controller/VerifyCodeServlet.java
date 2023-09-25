package top.dl.music.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * @author: minder
 * @createTime: 2023/09/25 18:59
 * @description:
 **/
@WebServlet("/verifyCodeServlet")
public class VerifyCodeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int width = 120;
        int height = 50;
        // 1.创建一对象，在内存中图片(验证码图片对象）
        BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB) ;
        // 2.美化图片
        // 2.1填充背最色
        // 画笔对象
        Graphics g = image.getGraphics();
        //设量画笔颜色
        g.setColor (Color.WHITE);
        g.fillRect(0,0, width,height);
        // 2.2画边框
        g.setColor(Color.BLUE);
        g.drawRect(0,0,width - 1,height - 1);
        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        //生成随机角标
        Random ran = new Random();

        for (int i = 1; i <= 5; i++) {
            int index = ran.nextInt(str.length());
            //获取随机字符
            char ch = str.charAt(index);
            //2.3写验证码
            g.drawString(ch + "",width / 5 * i,height / 3);
        }

        //2.4画干扰线
        g.setColor(Color.GREEN);
        //随机生成坐标点
        for (int i =0; i< 10; i++) {
            int x1 = ran.nextInt(width);
            int x2 = ran.nextInt(width);
            int y1 = ran.nextInt(height);
            int y2 = ran.nextInt(height);g.drawLine(x1,y1,x2,y2);
        }

        //3 .将图片输出到页面展示
        ImageIO.write(image,"jpg",resp.getOutputStream());
    }
}
