<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@include file="header.jsp"%>
<b>Login</b><br>
<%
    String s = (String) request.getAttribute("message");
    if(s != null){out.println(s);}
%>
<%
  Cookie[] allCookies = request.getCookies();
  String username="",password="",rememberMeVal="";
  if(allCookies!=null){
    for(Cookie c:allCookies){

        if(c.getName().equals("cUsername")){
            username = c.getValue();
        }

        if(c.getName().equals("cPassword")){
            password = c.getValue();
        }

        if(c.getName().equals("cRememberMe")){
            rememberMeVal = c.getValue();
        }

    }
  }
%>
<form method="post" action="login">
    Username: <input type="text" name="username" value="<%=username%>"><br>
    Password: <input type="password" name="password" value="<%=password%>"><br>
    <input type="checkbox" name="rememberMe" value="1" <%=rememberMeVal.equals(1) ?"checkd":""%>/>RememberMe<br/>
    <input type="submit" value="Login">
</form>
<%@include file="footer.jsp"%>