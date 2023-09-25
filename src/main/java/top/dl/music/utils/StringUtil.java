package top.dl.music.utils;

/**
 * @author: minder
 * @createTime: 2023/09/25 17:54
 * @description:
 **/
public class StringUtil {
    public static String subUri(String uri) {
        int position = uri.lastIndexOf("/");
        return uri.substring(position + 1);
    }
}
