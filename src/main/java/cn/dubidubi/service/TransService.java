package cn.dubidubi.service;

/**
 * @Auther: 16224
 * @Date: 2018/5/27 0027 15:50
 * @Description:
 */
public interface TransService {
    String getTiltle(int id);

    int setTitle(String title);

    void all(String title);
}
