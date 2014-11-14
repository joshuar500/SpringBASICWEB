<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Page</title>
    <link href="${pageContext.request.contextPath}/static/css/main.css" rel="stylesheet" type="text/css" />
</head>
<body onload='document.f.j_username.focus();'>
<h3>Login with Username and Password</h3>

<c:if test="${param.error != null}">
    <span class="loginerror">Login failed. Check that your username and password are correct.</span>
</c:if>

<form name='f' action='${pageContext.request.contextPath}/j_spring_security_check' method='POST'>
    <table>
        <tr>
            <td>User:</td>
            <td><input type='text' name='j_username' value=''></td>
        </tr>
        <tr>
            <td>Password:</td>
            <td><input type='password' name='j_password'/></td>
        </tr>
        <tr>
            <td>Remember me:</td>
            <td><input type='checkbox' name='_spring_security_remember_me' checked="checked" /></td>
        </tr>
        <tr>
            <td colspan='2'><input name="submit" type="submit" value="Login"/></td>
        </tr>
    </table>
</form>

<a href="${pageContext.request.contextPath}/register">Register</a>
</body>
</html>