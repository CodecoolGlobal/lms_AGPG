<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="com.codecool.web.model.LoggedInUser" %>
<!DOCTYPE html>
<html>
<head>
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
<div align="center">
    <form class="userprof" action="profile" method="post">
        <div class="userprof"><a href="userprofile.jsp">List users
            <input type="submit" value="Sign In">
        </a>
        </div>
    </form>
</div>
</body>
</html>
