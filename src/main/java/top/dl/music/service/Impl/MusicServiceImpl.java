package top.dl.music.service.Impl;

import top.dl.music.entity.Song;
import top.dl.music.mapper.SongMapper;
import top.dl.music.service.MusicService;
import top.dl.music.utils.MyBatisUtils;

import java.util.List;

/**
 * @author: minder
 * @createTime: 2023/09/20 17:00
 * @description:
 **/
public class MusicServiceImpl implements MusicService {

    @Override
    public List<Song> selectAll() {
        return (List<Song>) MyBatisUtils.executeQuery(sqlSession ->  {
            SongMapper mapper = sqlSession.getMapper(SongMapper.class);
            return mapper.selectAll();
        });
    }
}
