package org.java.dao;

import org.apache.ibatis.annotations.Param;
import org.java.entity.Prd;

import java.util.List;

/**
 * @Author: 马果
 * @Date: 2018/12/5 16:48
 * @Description:
 */
public interface PrdMapper {

    public List<Prd> getList();

    public Prd findById(@Param("pid") String pid);
}
