<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<div align="center">
    <body>
    <h1>我的博客</h1>
        <hr/>
        <c:forEach items="${myblogs}" var="myblog">
            <p>${myblog.txt}</p>
            <h6>${myblog.name}</h6>
            <h6>${myblog.date}</h6>
            <hr/>
        </c:forEach>
    </body>
</div>
</html>
