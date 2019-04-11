<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.codecool.web.model.LoggedInUser" %>
<!DOCTYPE html>
<html lang="en" dir="ltr">
<head>
    <meta charset="utf-8">
    <title>Add new assignment for the students!</title>
    <link rel="stylesheet" type="text/css" href="css-style.css">
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

<h1>Add an assignment</h1>
<form class="" action="assignment" method="post">
    <input size="50" type="text" name="question" value="" placeholder="What's the question?">
    <br>
    <h4>Set max points</h4>
    <select name="maxpoints" size="1" style="width: 195px !important; min-width: 195px; max-width: 195px;">
        <option value="1">1</option>
        <option value="2">2</option>
        <option value="3">3</option>
        <option value="4">4</option>
        <option value="5">5</option>
    </select>
    <br>
    <select name="published" size="1" style="width: 195px !important; min-width: 195px; max-width: 195px;">
        <option value="true">published</option>
        <option value="false">unpublished</option>
    </select>
    <br>
    <input type="submit" name="submit" value="Submit"
           style="width: 195px !important; min-width: 195px; max-width: 195px;">
</form>
</body>
</html>

