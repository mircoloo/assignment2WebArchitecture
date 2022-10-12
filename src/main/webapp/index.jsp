<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Assignment2</title>
        <link type="text/css" href="style.css">
    </head>
    <body>
    <jsp:include page="header.jsp"></jsp:include>
    <p>Your Score is <%= session.getAttribute("score") %></p>
    <br/>
    </body>
</html>