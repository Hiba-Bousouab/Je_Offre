<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>J'Offre.ma</title>
    <%@ include file="bootstrapIncludes.jsp" %>

</head>
    <body>
        <%@ include file="header.jsp" %>

        <c:forEach var="offer" items="${offers}" varStatus="status">
            <c:out value="${offer.titre} ${  status.count }"/>
        </c:forEach>



        <%@ include file="bootstrapIncludeLast.jsp" %>
    </body>
</html>
