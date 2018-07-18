package com.jfz.thymeleaf.redis.keySpace;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPubSub;

/**
 * @Author : steven.sheng
 * Description : TODO
 * Date : 2018/6/28 15:48
 */
public class RedisMsgPubSubListener extends JedisPubSub {

    private final Logger logger = LoggerFactory.getLogger(RedisMsgPubSubListener.class);

    @Autowired
    private JedisPool jedisPool;

    @Override
    public void onPSubscribe(String pattern, int subscribedChannels) {
        logger.info("Subscribe onPSubscribe----"+pattern+"--------"+subscribedChannels);
    }

    @Override
    public void onPMessage(String pattern, String channel, String message) {
        //监听消息
        logger.info("Subscribe onPMessage---pattern:"+pattern);
        logger.info("Subscribe onPMessage---channel:"+channel);
        logger.info("Subscribe onPMessage---message:"+message);
    }

    @Override
    public void onUnsubscribe(String channel, int subscribedChannels) {
        logger.info("channel:" + channel + "is been unsubscribed:" + subscribedChannels);
    }

}
