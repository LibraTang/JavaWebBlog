<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: LibraTang
  Date: 2018/10/24
  Time: 10:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>欢迎</title>
</head>
<body>
<div align="left">
    <h1>登录</h1>
    <form action="/Login" method="post">
        账号：<input type="text" name="account"><br>
        <br>
        密码：<input type="password" name="password"><br>
        <br>
        <input type="submit" value="登录">
    </form>
    <a href="register.jsp">还不是会员？</a>
</div>
<div>
    <table style="text-align: left; width: 510px;height: 88px;" border="0" cellpadding="2" cellspacing="2">
        <thead>
        <tr>
            <th><hr></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="blog" items="${blogs}">
            <tr>
                <td style="vertical-align: top">
                        ${blog.name}<br>
                    <c:out value="${blog.txt}"/><br>
                    <fmt:formatDate value="${blog.date}" type="both" dateStyle="full" timeStyle="full"/>
                    <hr>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
