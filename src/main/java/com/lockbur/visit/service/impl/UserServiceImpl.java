package com.lockbur.visit.service.impl;

import com.lockbur.visit.dao.UserDao;
import com.lockbur.visit.model.User;
import com.lockbur.visit.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

/**
 * 场景管理
 * Created by wangkun23 on 2017/3/23.
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    UserDao userDao;


    @Transactional
    public void save(User user) {
        Assert.notNull(user);
        userDao.insert(user);
    }
}
