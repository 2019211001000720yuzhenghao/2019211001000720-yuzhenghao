<%--
  Created by IntelliJ IDEA.
  User: 执笔写离殇
  Date: 2021/3/14
  Time: 12:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form>
    Name : <input type="text" name="name" required>
    PassWord : <input type="password" name="password" required minlength="8">
    email : <input type="email" name="email" required >
    birthdate : <input type="date" name="birthdate" required dataformatas="yyyy-mm-dd">
    <input type="submit" value="register">
</form>
</body>
</html>
