<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.codecool.web.model.LoggedInUser" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="css-style.css">
    <meta charset="UTF-8">
    <title>Add solution</title>
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
<br>

<h1>Solution View</h1>
<h2>Id: ${assignment.assignmentId}</h2>
<h2>${assignment.question}</h2>
<form action="answer" method="post">
    Please enter your solution:
    <br>
    <input type="hidden" name="id" value="${assignment.assignmentId}">
    <textarea type="text" name="answer" rows="5" cols="30"></textarea>
    <br>
    <input type="SUBMIT" value="Submit">
</form>

</body>

</html>
