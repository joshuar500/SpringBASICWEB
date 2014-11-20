<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<p><a href="${pageContext.request.contextPath}/offers">Show current offers</a></p>
<p><a href="${pageContext.request.contextPath}/createoffer">Add a new offer</a></p>
<sec:authorize access="hasRole('ROLE_ADMIN')">
    <p><a href="<c:url value='/admin' />">Admin</a></p>
</sec:authorize>
