<%--
  Created by IntelliJ IDEA.
  User: 执笔写离殇
  Date: 2021/3/14
  Time: 10:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<b>This is MyJsp page</b>
<a href="index.jsp">go to ecjtu</a>  <!--mothod is get-->
<form method="post"> <!--what is method whem we use to form?--><!--is get,why default is GET,form data is add in the url ,u can see-->
    <!--it is batter to use battle-->
    Name:<input type="text" name="name"><br/>
    ID:<input type="text" name="id"><br/>
    <input type="submit"  value="Send data to serve"/>
</form>
<%@include file="footer.jsp"%>
