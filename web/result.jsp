<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %><%--
  Created by IntelliJ IDEA.
  User: LibraTang
  Date: 2018/10/26
  Time: 21:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册结果</title>
</head>
<div align="center">
<body>
<%
    List<String> info = (List<String>) request.getAttribute("info"); //得到结果
    String s;

    //若用户有注册操作，则信息不为空
    if(info != null) {
        Iterator<String> iterator = info.iterator();
        while(iterator.hasNext()) {
            s = iterator.next();
            //若注册成功则跳转到登录
            if (s.equals("注册成功")) {
                response.sendRedirect("index.jsp");
            }
            //注册不成功提示错误
            else {
%>
<%--显示错误--%>
<h4><%=s%></h4>

<%
            }
        }
    }
%>
    <button onclick="{location.href='register.jsp'}">返回注册</button>
</body>
</div>
</html>
