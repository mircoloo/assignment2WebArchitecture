<%--
  Created by IntelliJ IDEA.
  User: mircobisoffi
  Date: 13/10/22
  Time: 10:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Assignment2-Game</title>
</head>
<body>
    <jsp:include page="header.jsp"></jsp:include>
    My points: <%= session.getAttribute("score") %>
    <br>
    <ol>
        <li>Algeries</li>
        <li>Yerevan</li>
        <li>N'Djamena</li>
        <li>Prague</li>
    </ol>
</body>
</html>
