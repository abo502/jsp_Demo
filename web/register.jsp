<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: A11200321050135
  Date: 2020/11/13
  Time: 10:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册页面</title>
</head>
<body>
<form action="<c:url value="/register"/>" method="post">
    <table text-align="center">
        <tr><td>用户名</td><td><input type="text" name="userName" ></td></tr>
        <tr><td>密码</td><td><input type="password" name="passWord" ></td></tr>
        <tr><td>年龄</td><td><input type="number" name="age" ></td></tr>
        <tr><td colspan="2"><input type="submit"  value="注册"></td></tr>
    </table>
</form>
</body>
</html>
