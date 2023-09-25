package top.dl.music.mapper;

import top.dl.music.entity.Song;

import java.util.List;

/**
 * @author: minder
 * @createTime: 2023/09/20 16:35
 * @description:
 **/
public interface SongMapper {
    /**
     *查询所有音乐
     *
     * @return List<Song>
     */
    List<Song> selectAll();
}
