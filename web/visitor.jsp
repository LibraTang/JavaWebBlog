<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: LibraTang
  Date: 2018/10/26
  Time: 20:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>你是游客</title>
</head>
<div align="center">
<body>
<h1>游客界面</h1>
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
