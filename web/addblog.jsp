<%--
  Created by IntelliJ IDEA.
  User: LibraTang
  Date: 2018/10/27
  Time: 15:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>写博客</title>
</head>
<div align="center">
<body>
    <h1>开始创作</h1>
    <form action="/ServletAddblog" method="get">
        <textarea name="blog" rows="20" cols="100"></textarea><br>
        <br>
        <input type="submit" value="完成">
    </form>
    <input type="button" onclick="history.back(-1);" value="返回">
</body>
</div>
</html>
