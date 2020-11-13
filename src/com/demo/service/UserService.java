package com.demo.service;

import com.demo.entity.User;

import java.util.List;

public interface UserService {
     boolean Login(String name,String password);
     boolean Register(String name,String password,int age);
     List<User> QueryUsers();
}
