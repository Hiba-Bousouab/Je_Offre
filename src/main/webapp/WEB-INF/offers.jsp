<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
    <body>
        <%@ include file="header.jsp" %>
        <c:forEach var="offer" items="${offers}">
            <c:out value="${ offer.description }"/>
        </c:forEach>

    </body>
</html>
