<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Assignment2</title>
        <link type="text/css" href="style.css">
    </head>
    <body>
    <jsp:include page="header.jsp"></jsp:include>
    <p>Your Score is <b><%= session.getAttribute("score") %></b></p>
    <br/>
    <a class="play-btn btn" href="GameServlet">Play</a>
    </body>
</html>