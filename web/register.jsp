<%--
  Created by IntelliJ IDEA.
  User: LibraTang
  Date: 2018/10/25
  Time: 8:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
</head>
<div align="center">
    <body>
        <h1>注册</h1>
        <form action="/ServletRegister" method="post">
            账号：<input type="text" name="account" placeholder="不多于15个英文字母"><br>
            <br>
            密码：<input type="password" name="password" placeholder="不多于16个英文字母"><br>
            <br>
            确认密码：<input type="password" name="confirmedPassword" placeholder="确认密码"><br>
            <br>
            <input type="submit" value="注册">
        </form>
    </body>
</div>
</html>
