<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>
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
<div align="center">
    <h1>登录</h1>
    <%
        List<String> info = (List<String>) request.getAttribute("info"); //得到结果
        String s;

        //若用户有登录操作，则信息不为空
        if(info != null) {
            Iterator<String> iterator = info.iterator();
            while(iterator.hasNext()) {
                s = iterator.next();
                //若登录成功则跳转到首页
                if (s.equals("登录成功")) {
                    response.sendRedirect("/ServletVIP");
                }
                //登录不成功提示错误
                else {
    %>
    <%--显示错误--%>
    <h4><%=s%></h4>

    <%
                }
            }
        }
    %>

    <form action="/ServletLogin" method="post">
        账号：<input type="text" name="account"><br>
        <br>
        密码：<input type="password" name="password"><br>
        <br>
        <input type="submit" value="登录">
    </form>

    <a href="register.jsp">还不是会员？</a><br>
    <br>
    <a href="/ServletVisitor">以游客身份访问</a>
</div>
</body>
</html>
