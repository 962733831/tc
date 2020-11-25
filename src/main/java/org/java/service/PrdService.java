package org.java.service;

import org.apache.ibatis.annotations.Param;
import org.java.entity.Prd;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: 马果
 * @Date: 2018/12/5 16:49
 * @Description:
 */
public interface PrdService {


    public List<Prd> getList();

    public Prd findById(String pid);
}
