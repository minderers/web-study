package top.dl.music.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author: minder
 * @createTime: 2023/09/20 13:59
 * @description:
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Song {
    private Integer id;

    private String name;

    private  String singer;

    private String path;

    private String cover;

    private String lyric;

    private Date createTime;
}
