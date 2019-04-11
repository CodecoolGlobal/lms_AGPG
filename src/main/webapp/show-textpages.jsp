<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.codecool.web.model.LoggedInUser" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" type="text/css" href="css-style.css">
    <meta charset="UTF-8">
    <title>View Study Material</title>
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

<h1>Material</h1>
<br>
<div class="textpage">

    <table class="list" border="1" border-color="white">
        <tr>
            <th>Text Title</th>
            <th>Published?</th>
            <th>Link</th>


        </tr>
        <c:forEach var="t" items="${textpages}">
            <tr>
                <td>${t.getTitle()}</td>
                <td>${t.isPublished()}</td>
                <td>
                    <form action="show-textcontent" method="get">
                        <input type="hidden" name="text-title" value="${t.getTitle()}">
                        <input type="hidden" name="text-content" value="${t.getTextContent()}">
                        <input type="submit" value="Redirect">
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
