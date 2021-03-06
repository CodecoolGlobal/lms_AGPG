<%@ page import="com.codecool.web.model.LoggedInUser" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.codecool.web.model.LoggedInUser" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" type="text/css" href="css-style.css">
    <meta charset="UTF-8">
    <title>My Profile</title>
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
<h1>My Profile</h1>
<form class="modify" method="post" action="myprofile">
    <input type="text" name="email" placeholder="${email}" readonly>
    <input type="text" placeholder="Type new name here" id="username" name="fullname" pattern="[A-Za-z ]{0,32}">
    <input type="radio" name="position" value="mentor" id="radio2">
    <label for="mentor" name=rbutton>Mentor</label>
    <input type="radio" name="position" value="student" id="radio1">
    <label for="student" name=rbutton>Student</label>
    <input type="submit" value="Update"></a>
</form>
</body>
</html>
