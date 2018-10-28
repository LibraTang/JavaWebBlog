<%--
  Created by IntelliJ IDEA.
  User: LibraTang
  Date: 2018/10/27
  Time: 17:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>编辑</title>
</head>
<div align="center">
<body>
<h1>编辑</h1>
<form action="/ServletModifyblog" method="get">
    <textarea name="blog" rows="20" cols="100"><%=request.getParameter("txt")%></textarea><br>
    <br>
    <%--隐藏提交--%>
    <input type="hidden" name="id" value=<%=request.getParameter("id")%>>
    <input type="submit" value="完成">
</form>
<input type="button" onclick="history.back(-1);" value="返回">
</body>
</div>
</html>
