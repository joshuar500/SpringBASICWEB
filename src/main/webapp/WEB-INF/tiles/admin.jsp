<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
This is the admin page. Authorized users only.<br />
<table>
    <tr><td>Username</td><td>Email</td><td>Role</td><td>Enabled</td></tr>
    <%--"users" is passed in via the controller--%>
    <c:forEach var="user" items="${users}">
        <tr>
            <td><c:out value="${user.username}" /></td>
            <td><c:out value="${user.email}" /></td>
            <td><c:out value="${user.authority}" /></td>
            <td><c:out value="${user.enabled}" /></td>
        </tr>
    </c:forEach>
</table>
