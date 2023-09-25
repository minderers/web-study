package top.dl.music.service;

import top.dl.music.entity.Song;

import java.util.List;

/**
 * @author: minder
 * @createTime: 2023/09/20 14:00
 * @description:
 **/
public interface MusicService {
    /**
     *查询所有音乐
     *
     * @return List<Song>
     */
    List<Song> selectAll();
}
