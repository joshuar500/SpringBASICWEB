<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<h2>Create new account</h2>

<sf:form id="details" method="post" action="${pageContext.request.contextPath}/createaccount" commandName="user">
    <table>
        <tr>
            <%--re-align the sf errors--%>
            <td>Username: </td><td><sf:input name="username" type="text" path="username"></sf:input><br /><sf:errors path="username" cssClass="error" /></td>
        </tr>
        <tr>
            <td>Email: </td><td><sf:input name="email" type="text" path="email"></sf:input><br /><sf:errors path="email" cssClass="error" /></td>
        </tr>
        <tr>
            <td>Password: </td><td><sf:input id="password" name="password" type="text" path="password"></sf:input><br /><sf:errors path="password" cssClass="error" /></td>
        </tr>
        <tr>
            <td>Confirm Password: </td><td><input id="confirmPassword" name="confirmPassword" type="text" /><br /><div id="matchpass"></div></td>
        </tr>
        <tr>
            <td><input value="Create Account" type="submit" /></td>
        </tr>
    </table>
</sf:form>