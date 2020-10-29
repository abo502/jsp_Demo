package com.demo.service;

import com.demo.entity.User;

import java.util.List;

public interface UserService {
     boolean Login(String name,String password);
     List<User> QueryUsers();
}
