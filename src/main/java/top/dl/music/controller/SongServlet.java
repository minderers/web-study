package top.dl.music.controller;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import top.dl.music.entity.Song;
import top.dl.music.mapper.SongMapper;
import top.dl.music.service.Impl.MusicServiceImpl;
import top.dl.music.service.MusicService;
import top.dl.music.utils.ResponseUtils;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * @author: minder
 * @createTime: 2023/09/20 14:00
 * @description:
 **/
@WebServlet("/music/*")
@Slf4j
public class SongServlet extends HttpServlet {
    private final MusicService musicService = new MusicServiceImpl();

    @Override
    public void init(ServletConfig config) throws ServletException {
        log.info("init");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestURI = req.getRequestURI();
        log.info(requestURI);
        int position = requestURI.lastIndexOf("/");
        String method = requestURI.substring(position + 1);
        log.info(method);
        switch (method){
            case "list" -> {
                selectList(req, resp);
            }
            case "add" -> {
                add(req, resp);
            }
        }
    }
    private void selectList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ResponseUtils responseUtils;
        List<Song> songs = musicService.selectAll();
        responseUtils = new ResponseUtils().put("list",songs);
        resp.setContentType("application/json;charset=UTF-8");
        resp.getWriter().println(responseUtils.toJsonString());
    }
    private void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("新增歌曲");
    }


    @Override
    public void destroy() {
        log.info("destroy");
    }
}
