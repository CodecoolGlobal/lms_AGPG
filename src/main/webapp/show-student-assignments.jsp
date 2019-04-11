<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.codecool.web.model.LoggedInUser" %>
<%@ page contentType="text/html; charset=UTF-8" %>

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

<h1>Student Assignments</h1>
<br>
<div class="assignments">
    <table class="list" border="1" border-color="white">
        <tr>
            <th>id</th>
            <th>Question</th>
            <th>Date</th>
            <th>Max points</th>
            <th>View Assignment</th>
        </tr>
        <c:forEach var="t" items="${assignment}">
            <tr>
                <td>${t.getAssignmentId()}</td>
                <td>${t.getQuestion()}</td>
                <td>${t.getDate().toString()}</td>
                <td>${t.getMaxPoints()}</td>
                <td>
                    <form class="" action="assignment-page" method="post">
                        <input type="hidden" name="id" value="${t.assignmentId}">
                        <input type="submit">
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
