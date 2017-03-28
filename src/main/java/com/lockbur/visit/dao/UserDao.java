package com.lockbur.visit.dao;


import com.lockbur.visit.model.User;

/**
 * 条件信息数据操作
 * Created by wangkun23 on 2017/3/27.
 */
public interface UserDao {

    /**
     * 保存
     * @param entity
     * @return
     */
    public Integer insert(User entity);
}
