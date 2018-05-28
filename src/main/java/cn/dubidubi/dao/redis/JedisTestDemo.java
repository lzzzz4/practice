package cn.dubidubi.dao.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

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
        for (String key : keys) {
            System.out.println(key);
        }
        resource.close();
    }

    public static void demo(int ...i){
        for (int j = 0; j < i.length; j++) {
            int i1 = i[j];
            System.out.println(i1);
        }
    }

}
