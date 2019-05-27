<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.codecool.web.model.LoggedInUser" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="com.codecool.web.model.TextPage" %>


<!DOCTYPE html>

<html lang="en">
<head>
    <link rel="stylesheet" type="text/css" href="css-style.css">
    <meta charset="UTF-8">
    <title>View Study Content</title>
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

<h1>Study Content</h1>
<br>
<div class="wrapper-text">
    <div class="container-text">
        <h2 class="text-title"><%= request.getParameter("text-title") %>
        </h2>
        <br>
        <p><%= request.getParameter("text-content") %>
        </p>
    </div>
</div>
</body>
</html>
