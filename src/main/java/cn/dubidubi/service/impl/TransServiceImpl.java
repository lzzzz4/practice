package cn.dubidubi.service.impl;

import cn.dubidubi.dao.chanMapper;
import cn.dubidubi.service.TransService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Auther: 16224
 * @Date: 2018/5/27 0027 15:51
 * @Description:
 */
@Service
public class TransServiceImpl implements TransService {
    @Autowired
    public chanMapper chanMapper;

    @Override
    public String getTiltle(int id) {
        String string = chanMapper.getTitle(id);
        return string;
    }

    @Override
    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public int setTitle(String title) {
        int id = chanMapper.saveOneTitle(title);
        return id;
    }

    @Override
    @Transactional
    public void all(String title) {
        int id = setTitle(title);
        String hello = getTiltle(id);
        System.out.println(hello);
    }


}
