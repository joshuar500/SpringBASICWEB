<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<body>
    <h2>Results</h2>

    <c:forEach var="offer" items="${offers}">
        <p><c:out value="${offer}" /></p>
    </c:forEach>
</body>
</html>