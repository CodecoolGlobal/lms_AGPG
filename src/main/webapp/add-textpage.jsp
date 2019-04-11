<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.codecool.web.model.LoggedInUser" %>
<!DOCTYPE html>
<html lang="en" dir="ltr">
<head>
    <meta charset="utf-8">
    <title>Add new text page!</title>
</head>
<body>
<div class="navbar">
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
</div>

<h1>Add new text page</h1>
<form class="" action="addtextpage" method="post">
    <input type="text" name="textpage_title" value="" placeholder="What's the title of this text page?">
    <br>
    <br>
    <textarea rows="5" cols="80" id="textpage" placeholder="Write your things here!" name="textpage_value"></textarea>
    <br>
    <select name="published" size="2">
        <option value="true">published</option>
        <option value="false">unpublished</option>
    </select>
    <input type="submit" name="submit" value="Submit">
</form>
</body>
</html>
