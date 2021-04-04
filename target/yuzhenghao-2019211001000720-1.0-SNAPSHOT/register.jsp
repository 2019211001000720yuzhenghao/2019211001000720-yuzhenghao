<%--
  Created by IntelliJ IDEA.
  User: 执笔写离殇
  Date: 2021/3/14
  Time: 12:26
  To change this template use File | Settings | File Templates.
--%>

<%@include file="header.jsp"%>
<b>This is my register JSP page</b>
<form method="post" action="register">
    Username : <input type="text" name="username" required/><br/>
    Password : <input type="password" name="password" required minlength="8"/><br/>
    Email : <input type="email" name="email" required/><br/>
    Gender: <input type="radio" name="gender" value="male">Male<input type="radio" name="gender" value="female">Female<br/>
    Date of Birth : <input type="text name=" name="birthDate"><br/>
    <input type="submit" value="Register"/><br/>
</form>
<%@include file="footer.jsp"%>