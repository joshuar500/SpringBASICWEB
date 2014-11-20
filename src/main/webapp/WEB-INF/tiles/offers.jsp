<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <h2>Results</h2>
    <c:forEach var="offer" items="${offers}">
        Name: <c:out value="${offer.name}" /> /// Email: <c:out value="${offer.email}" /> /// Text: <c:out value="${offer.text}" />< br/>
    </c:forEach>