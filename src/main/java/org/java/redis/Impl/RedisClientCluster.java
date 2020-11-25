package org.java.redis.Impl;

import org.java.redis.RedisClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.JedisCluster;

@Component("cluster")
public class RedisClientCluster  implements RedisClient {
    @Autowired
    private JedisCluster cluster;
    @Override
    public void set(String key, String value) {
        cluster.set(key,value);
    }

    @Override
    public String get(String key) {
        return cluster.get(key);
    }

    @Override
    public void hset(String key, String field, String value) {
        cluster.hset(key,field,value);
    }

    @Override
    public String hget(String key, String field) {
        return cluster.hget(key,field);
    }

    @Override
    public void del(String key) {
        cluster.del(key);
    }
}
