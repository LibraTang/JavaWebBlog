<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%--
  Created by IntelliJ IDEA.
  User: LibraTang
  Date: 2018/10/26
  Time: 23:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>我的博客</title>
</head>
<div align="left">
    <button onclick="{location.href='addblog.jsp'}">写博客</button><br>
    <br>
    <button onclick="{location.href='/ServletVIP'}">返回主页</button>
</div>
<div align="center">
    <body>
    <h1>我的博客</h1>
        <hr/>
        <c:forEach items="${myblogs}" var="myblog">
            <p>${myblog.txt}</p>
            <h6>By ${myblog.name}</h6>
            <h6>${myblog.date}</h6>
            <button onclick="location.href='/ServletDeleteblog?id=${myblog.id + ""}'">删除</button>
            <button onclick="location.href='modifyblog.jsp?txt=${myblog.txt}&id=${myblog.id + ""}'">编辑</button>
            <hr/>
        </c:forEach>
    </body>
</div>
</html>
