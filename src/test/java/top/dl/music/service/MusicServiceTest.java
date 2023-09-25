package top.dl.music.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import top.dl.music.entity.Song;
import top.dl.music.service.Impl.MusicServiceImpl;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author: minder
 * @createTime: 2023/09/20 17:17
 * @description:
 **/
@Slf4j
class MusicServiceTest {
    private final MusicService musicService = new MusicServiceImpl();

    @Test
    void selectAll() {
        List<Song> songs = musicService.selectAll();
        songs.forEach(song -> log.info(String.valueOf(song)));
    }
}