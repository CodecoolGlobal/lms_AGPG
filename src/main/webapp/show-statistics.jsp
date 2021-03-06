<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.codecool.web.model.LoggedInUser" %>
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

<c:choose>
    <c:when test="${LoggedInUser.getLoggedInUser().isMentor()}">
        <jsp:include page='header-mentor.jsp'>
            <jsp:param name="" value=""/>
        </jsp:include>
    </c:when>
    <c:otherwise>
        <jsp:include page='header-student.jsp'>
            <jsp:param name="" value=""/>
        </jsp:include>
    </c:otherwise>
</c:choose>
<h1>Statistics</h1>
<br>
<div class="table-wrapper">
    <table class="table-container">
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
