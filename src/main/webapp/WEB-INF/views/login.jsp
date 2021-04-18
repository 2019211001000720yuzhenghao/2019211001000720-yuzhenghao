<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@include file="header.jsp"%>
<b>Login</b><br>
<%
    String s = (String) request.getAttribute("message");
    if(s != null){out.println(s);}
%>
<form method="post" action="login">
    Username: <input type="text" name="username"><br>
    Password: <input type="password" name="password"><br>
    <input type="submit" value="Login">
</form>
<%@include file="footer.jsp"%>