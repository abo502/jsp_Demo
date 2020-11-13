package com.demo.dao;

import com.demo.DBUtil.MysqlHelper;
import com.demo.entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BaseDao {

    public boolean login(String username, String password) {
        String sql = "select name,password from user";
        ResultSet resultSet = MysqlHelper.executeQuery(sql);
        try {
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String pwd = resultSet.getString("password");
                if (name.equals(username) && pwd.equals(password)) {
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean register(String username, String password, int age) {
        String sql = "insert into user(name,password,age) values (?,?,?)";
        int resultSet = MysqlHelper.executeUpdate(sql, username,password,age);
        return resultSet != 0;
    }

    public List<User> queryUsers() {
        ArrayList<User> userList = new ArrayList<>();
        String sql = "select * from user";
        ResultSet resultSet = MysqlHelper.executeQuery(sql);
        try {
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }


}
