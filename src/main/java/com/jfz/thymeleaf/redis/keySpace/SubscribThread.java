package com.jfz.thymeleaf.redis.keySpace;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * @Author : steven.sheng
 * Description : TODO
 * Date : 2018/6/28 15:52
 */
@Component
public class SubscribThread implements CommandLineRunner {

    private final Logger logger = LoggerFactory.getLogger(SubscribThread.class);
    public final static String LISTENER_PATTERN = "__keyevent@*__:expired";//多节点
    @Autowired
    private JedisPool jedisPool;

    @Override
    public void run(String... strings) throws Exception {
        Jedis jedis = jedisPool.getResource();
        try{
            jedis.psubscribe(new RedisMsgPubSubListener(),LISTENER_PATTERN);
        }catch (Exception e){
            logger.error("redis pSubscribe error",e);
        }finally {
            jedis.close();
        }
    }
}
