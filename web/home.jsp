<%@ page import="com.demo.entity.User" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: A11200321050135
  Date: 2020/11/30
  Time: 9:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户页面</title>
</head>
<body>
   <table border="1px">
       <tr>
           <td>id</td>
           <td>用户名</td>
       </tr>
       <%List<User> list= (List<User>) session.getAttribute("users");
           for (User user : list) {
       %>
       <tr>
           <td><%=user.getId()%></td>
           <td><%=user.getName()%></td>
       </tr>
       <%
           }
       %>
   </table>
</body>
</html>
