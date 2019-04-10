<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="com.codecool.web.*" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Arrays" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <link rel="stylesheet" type="text/css" href="css-style.css">
        <meta charset="UTF-8">
        <title>View Assignment</title>
    </head>
    <body>
        <div class="navbar">
            <jsp:include page='header-mentor.jsp'>
                <jsp:param name="" value=""/>
            </jsp:include>
        </div>
        <br>
        <h1>Logged in with: ${email} </h1>
        <h1>Statistics</h1>
        <div class="textpage">

            <table class="list" border="1" border-color="white">
                <tr>
                    <th>Question</th>
                    <th>Answer</th>
                    <th>Grade</th>
                </tr>

                <c:forEach var="question" items="${questions}" varStatus="status">
                     <tr>
                          <td>${question}</td>
                          <td>${answers[status.index]}</td>
                          <td>${grades[status.index]}</td>
                     </tr>
                </c:forEach>
            </table>
        </div>
    </body>
  </html>
