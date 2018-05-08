package cn.dubidubi.util;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import javax.sound.midi.Soundbank;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

/**
 * @Auther: 16224
 * @Date: 2018/5/2 0002 19:17
 * @Description:
 */
public class MyRedis {
    public static void main(String[] args){
        //设置通用的连接池
        JedisPoolConfig GenericObjectPoolConfig =new JedisPoolConfig();
        //确保每个连接都可用
        GenericObjectPoolConfig.setTestOnBorrow(true);
        GenericObjectPoolConfig.setMaxTotal(10);
        JedisPool JedisPool =new JedisPool(GenericObjectPoolConfig,"119.29.28.81",6379,5000,"linzijie");
        Jedis jedisConnection = JedisPool.getResource();
        Set<String> keys = jedisConnection.keys("*");
        Iterator<String> iterator = keys.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        jedisConnection.close();
        JedisPool.close();
    }
}
