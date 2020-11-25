package org.java.redis;

public interface RedisClient {
    public void set(String key,String value);
    public String get(String key);

    public void hset(String key,String field,String value);
    public String hget(String key,String field);

    public void del(String key);
}
