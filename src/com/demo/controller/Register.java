package com.demo.controller;

import com.demo.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Register extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("gbk");
        String userName=req.getParameter("userName");
        String passWord=req.getParameter("passWord");
        int age= Integer.parseInt(req.getParameter("age"));
        boolean flag=new UserServiceImpl().Register(userName,passWord,age);
        PrintWriter writer = resp.getWriter();
        if (flag){
            resp.sendRedirect("/index");
            writer.println("注册成功!!!");
        }else {
            writer.println("注册失败!!!");
        }
        writer.flush();
        writer.close();
    }
}
