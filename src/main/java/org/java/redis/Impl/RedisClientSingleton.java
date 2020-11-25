package org.java.redis.Impl;

import org.java.redis.RedisClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@Component
public class RedisClientSingleton implements RedisClient {
    @Autowired
    private JedisPool jedisPool;
    @Override
    public void set(String key, String value) {
        Jedis jedis = jedisPool.getResource();
        jedis.set(key,value);
        jedis.close();
    }

    @Override
    public String get(String key) {
        Jedis jedis = jedisPool.getResource();
        String value = jedis.get(key);
        jedis.close();
        return value;
    }

    @Override
    public void hset(String key, String field, String value) {
        Jedis jedis = jedisPool.getResource();
        jedis.hset(key,field,value);
        jedis.close();
    }

    @Override
    public String hget(String key, String field) {
        Jedis jedis = jedisPool.getResource();
        String value = jedis.hget(key, field);
        jedis.close();
        return value;
    }

    @Override
    public void del(String key) {
        Jedis jedis = jedisPool.getResource();
        jedis.del(key);
        jedis.close();
    }
}
