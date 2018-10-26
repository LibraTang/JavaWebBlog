<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: LibraTang
  Date: 2018/10/25
  Time: 10:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>博客</title>
</head>
<div align="left">
    <button onclick="{location.href='/ServletMyblog'}">我的博客</button><br>
    <br>
    <button onclick="{location.href='/ServletAddblog'}">写博客</button>
</div>
<div align="center">
    <body>
    <h1>主页</h1>
    <hr/>
    <c:forEach items="${blogs}" var="blog">
        <p>${blog.txt}</p>
        <h6>${blog.name}</h6>
        <h6>${blog.date}</h6>
        <hr/>
    </c:forEach>
    </body>
</div>
</html>
