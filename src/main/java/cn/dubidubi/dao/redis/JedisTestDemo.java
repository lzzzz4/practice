package cn.dubidubi.dao.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.Iterator;
import java.util.Set;

/**
 * @Auther: 16224
 * @Date: 2018/5/2 0002 21:13
 * @Description: redis与spring整合测试
 */
@Repository
public class JedisTestDemo {
    @Autowired
    JedisPool jedisPool;
    public void test(){
        Jedis resource = jedisPool.getResource();
        Set<String> keys = resource.keys("*");
        Iterator<String> iterator = keys.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        resource.close();
    }
}
