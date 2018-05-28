package cn.dubidubi.service.impl;

import cn.dubidubi.model.User;
import cn.dubidubi.service.TestService;
import org.springframework.stereotype.Service;

/**
 * @Auther: 16224
 * @Date: 2018/5/10 0010 21:38
 * @Description:
 */
@Service("service2")
public class TestService2Impl implements TestService {
    @Override
    public void hello(String Username, User user) {
        System.out.println("2");
    }

    @Override
    public void save(String name) {
        System.out.println("2");
    }
}
