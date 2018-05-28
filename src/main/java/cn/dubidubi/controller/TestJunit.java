package cn.dubidubi.controller;

import java.time.LocalDateTime;


import cn.dubidubi.dao.redis.JedisTestDemo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.dubidubi.model.User;
import cn.dubidubi.service.TestService;
import redis.clients.jedis.JedisPool;

@Controller
@RequestMapping("/lzj")
/**
 * @ClassName: TestJunit
 * @Description: aop
 * @author 16224
 * @date 2018年4月25日
 *
 */
public class TestJunit {

    @Autowired
    @Qualifier("service2")
    TestService TestService;
    @Autowired
    JedisTestDemo JedisTestDemo;

    @RequestMapping("/zz")
    public void a() {

        User user = new User();
        user.setUsername("1111");
        user.setDateTime(LocalDateTime.now());
        TestService.hello("lzj", user);
        TestService.save("lzj");
    }

    @RequestMapping("/redis")
    public void redis() {
        JedisTestDemo.test();
    }
}
