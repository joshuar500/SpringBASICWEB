<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title></title>
</head>
<link href="${pageContext.request.contextPath}/static/css/main.css" rel="stylesheet" type="text/css" />
<body>


<form method="post" action="${pageContext.request.contextPath}/docreate">
    <table>
        <tr>
            <td>Name: </td><td><input name="name" type="text" /></td>
        </tr>
        <tr>
            <td>Email: </td><td><input name="email" type="text" /></td>
        </tr>
        <tr>
            <td>Your offer: </td><td><textarea name="text" type="text" rows="10" cols="20"></textarea></td>
        </tr>
        <tr>
            <td><input value="Create advert" type="submit" /></td>
        </tr>
    </table>
</form>


</body>
</html>
