package com.demo.service.impl;

import com.demo.dao.BaseDao;
import com.demo.entity.User;
import com.demo.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    private BaseDao baseDao = new BaseDao();

    @Override
    public boolean Login(String name, String password) {
        return baseDao.login(name, password);
    }

    @Override
    public List<User> QueryUsers() {
        return baseDao.queryUsers();
    }
}
