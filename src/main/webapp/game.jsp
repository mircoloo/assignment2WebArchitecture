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
        <li>Rome</li>
        <li>Berlin</li>
        <li>Lisbona</li>
        <li>Bruxelles</li>
        <li>Paris</li>
        <li>Bucarest</li>
    </ol>

    <div class="game-div">
        <form action="GameCheckerServlet" method="post">

            <% String flags[] = (String[]) session.getAttribute("flags");%>
            <div class="flag-row">
                <img src="./images/${flags[0]}.png" />
                <select class="capitals-selector" name="capital1">
                    <option value="Rome">1</option>
                    <option value="Berlin">2</option>
                    <option value="Lisbona">3</option>
                    <option value="Bruxelles">4</option>
                    <option value="Paris">5</option>
                    <option value="Bucarest">6</option>
                </select>
            </div>
            <div class="flag-row">
                <img src="./images/${flags[1]}.png" />
                <select class="capitals-selector" name="capital2">
                    <option value="Rome">1</option>
                    <option value="Berlin">2</option>
                    <option value="Lisbona">3</option>
                    <option value="Bruxelles">4</option>
                    <option value="Paris">5</option>
                    <option value="Bucarest">6</option>
                </select>
            </div>
            <div class="flag-row">
                <img src="./images/${flags[2]}.png" />
                <select class="capitals-selector" name="capital3">
                    <option value="Rome">1</option>
                    <option value="Berlin">2</option>
                    <option value="Lisbona">3</option>
                    <option value="Bruxelles">4</option>
                    <option value="Paris">5</option>
                    <option value="Bucarest">6</option>
                </select>
            </div>


            <input type="submit" value="Submit">

        </form>





    </div>
</body>
</html>
