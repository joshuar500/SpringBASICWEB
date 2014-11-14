<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html>
<head>
    <title></title>
</head>
<body>
<p><a href="${pageContext.request.contextPath}/offers">Show current offers</a></p>
<p><a href="${pageContext.request.contextPath}/createoffer">Add a new offer</a></p>

<sec:authorize access="!isAuthenticated()">
    <p><a href="${pageContext.request.contextPath}/login">Login</a></p>
</sec:authorize>
<sec:authorize access="!isAuthenticated()">
    <p><a href="${pageContext.request.contextPath}/register">Register</a></p>
</sec:authorize>
<sec:authorize access="isAuthenticated()">
    <p><a href="<c:url value='/j_spring_security_logout' />">Logout</a></p>
</sec:authorize>
<sec:authorize access="hasRole('ROLE_ADMIN')">
    <p><a href="<c:url value='/admin' />">Admin</a></p>
</sec:authorize>
</body>
</html>
