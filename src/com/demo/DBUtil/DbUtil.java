package com.demo.DBUtil;

import java.sql.*;

public class DbUtil {
    private static String DBDriver = "com.mysql.cj.jdbc.Driver";
    private static String User = "root";
    private static String Password = "123456";
    private static String URL = "jdbc:mysql://localhost:3306/test?characterEncoding=UTF-8&serverTimezone=UTC";
    static Connection connection = null;
    static PreparedStatement preparedStatement=null;
    static Statement statement=null;


    public static Connection getConnection(){
        try {
            Class.forName(DBDriver);
            connection=DriverManager.getConnection(URL,User,Password);
            return connection;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Statement createStatement(){
        try {
            statement=getConnection().createStatement();
            return statement;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static PreparedStatement createPreparedStatement(String sql){
        try {
            preparedStatement=getConnection().prepareStatement(sql);
            return preparedStatement;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void closeAll(){
        if (preparedStatement==null){
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (statement==null){
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (connection==null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
