<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: A11200321050135
  Date: 2020/10/29
  Time: 13:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>登录</title>
  </head>
  <body>
  <form action="login" method="post">
    <table>
      <tr><td>用户名</td><td><input type="text" name="userName" ></td></tr>
      <tr><td>密码</td><td><input type="password" name="passWord" ></td></tr>
      <tr><td colspan="2"><input type="submit"  value="登录"></td></tr>
    </table>
    <div>
      <a href="<c:url value="/register.jsp"/>">立即注册</a>
    </div>
  </form>
  </body>
</html>
