<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>
        <tiles:insertAttribute name="title" />
    </title>
    <link href="${pageContext.request.contextPath}/static/css/main.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/script/jquery-1.11.1.min.js"></script>

    <tiles:insertAttribute name="includes" />

</head>
<body>

<div class="header">
    <tiles:insertAttribute name="header" />
</div>

<div class="content">
    <tiles:insertAttribute name="content" />
</div>

<hr />

<div class="footer">
    <tiles:insertAttribute name="footer" />
</div>
</body>
</html>
