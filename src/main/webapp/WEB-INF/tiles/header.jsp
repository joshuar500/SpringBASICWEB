<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<a href="<c:url value='/' />">Home</a>
<sec:authorize access="!isAuthenticated()">
    <a href="${pageContext.request.contextPath}/login">Login</a>
</sec:authorize>
<sec:authorize access="isAuthenticated()">
    <a href="<c:url value='/j_spring_security_logout' />">Logout</a>
</sec:authorize>
<sec:authorize access="!isAuthenticated()">
    <a href="${pageContext.request.contextPath}/register">Register</a>
</sec:authorize>