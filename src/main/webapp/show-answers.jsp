<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.codecool.web.model.LoggedInUser" %>

<!DOCTYPE html>
<head>
    <link rel="stylesheet" type="text/css" href="css-style.css">
    <meta charset="UTF-8">
    <title>My Profile</title>
</head>

<html lang="en">
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


<h1>Answers</h1>
<br>
<div class="table-wrapper">
<table class="list1">
    <tr>
        <th>Answer</th>
        <th>Grade</th>
        <th>Submit grade</th>
    </tr>
    <c:forEach items="${answerList}" var="a">
        <tr>
            <td class="answer">
                <div class="textbox">
                        ${a.answer}<br>
                </div>
            </td>
            <td>
                    ${a.grade}<br>
            </td>
            <td>
                <form action="grade" method="post">
                    <input type="hidden" name="testId" value="${testId}">
                    <select name="gradings">
                        <option value="1">1</option>
                        <option value="2">2</option>
                        <option value="3">3</option>
                        <option value="4">4</option>
                        <option value="5">5</option>
                    </select>
                    <input type="submit" value="Submit">
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
</div>
</body>
</html>
