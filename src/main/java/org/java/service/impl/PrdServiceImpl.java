package org.java.service.impl;

import org.java.dao.PrdMapper;
import org.java.entity.Prd;
import org.java.redis.RedisClient;
import org.java.service.PrdService;
import org.java.util.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @Author: 马果
 * @Date: 2018/12/5 16:50
 * @Description:
 */
@Service
public class PrdServiceImpl implements PrdService {
    @Autowired
    private PrdMapper mapper;

    @Autowired
    @Qualifier("cluster")
    private RedisClient redisClient;

    @Override
    public List<Prd> getList() {
        String json = redisClient.hget("redis_j54_singleton", "getList");

        if (StringUtils.isEmpty(json)){
            System.out.println("=====================");
            List<Prd> list = mapper.getList();

            json = JsonUtils.objectToJson(list);
            redisClient.hset("redis_j54_singleton","getList",json);
            return list;
        }else {
            System.out.println("++++++++++++++++++");
            List<Prd> list = JsonUtils.jsonToList(json, Prd.class);
            return list;
        }

    }

    @Override
    public Prd findById(String pid) {
        String json = redisClient.hget("redis_j54_singleton", pid);
        if (StringUtils.isEmpty(json)){
            System.out.println("##############");
            Prd prd = mapper.findById(pid);
            json = JsonUtils.objectToJson(prd);
            redisClient.hset("redis_j54_singleton",pid,json);
            return prd;
        }else {
            System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@");
            Prd prd = JsonUtils.jsonToPojo(json, Prd.class);
            return prd;
        }

    }
}
