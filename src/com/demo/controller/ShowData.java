package com.demo.controller;

import com.demo.entity.User;
import com.demo.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class ShowData extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List list=new UserServiceImpl().QueryUsers();
        String pageIndex1=req.getParameter("pageIndex");
        if(pageIndex1==null){
            pageIndex1="0";
        }
        int pageIndex=Integer.parseInt(pageIndex1);  //拿到传递过来的请求的第几条记录
        resp.setCharacterEncoding("gbk");
        PrintWriter pw=resp.getWriter();
        StringBuilder sb=new StringBuilder();  //字符串的缓存区
        //int pageIndex=0;   //这是第几页
        int pageSize=3;   //就是每一页要显示的数据总记录数
        for(int j=0;j<list.size()/pageSize;j++)
        {
            sb.append("<a href='show?pageIndex="+j+"'>"+(j+1)+"</a>&nbsp&nbsp&nbsp");
        }
        for(int i=pageIndex*pageSize;i<(pageIndex+1)*pageSize;i++){
            User u=(User)list.get(i);
            sb.append("<html><head></head><body><table>");
            sb.append("<tr><td>用户编号"+u.getId()+"</td>");
            sb.append(String.format("<td>用户名%s</td>", u.getName()));
            sb.append("<td><a href='add.html'>增加</a></td>");
            sb.append("<td><a href='delete.html'>删除</a></td>");
            sb.append("<td><a href='modifyData?userName="+u.getName()+"'>修改</a></td>");
            sb.append("</tr>");
        }
        sb.append("</table></body></html>");
        pw.write(sb.toString());
        pw.flush();
        pw.close();
    }
}
