package com.demo.controller;
import com.demo.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


//@WebServlet("/login")
public class HomeServlet extends HttpServlet {
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
        boolean flag=new UserServiceImpl().Login(userName,passWord);
        PrintWriter writer = resp.getWriter();
        if (flag){
            resp.sendRedirect("/show");
            writer.println("登录成功!!!");
        }else {
            writer.println("账号密码错误!!!");
        }
        writer.flush();
        writer.close();
    }
}
