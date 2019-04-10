<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<head>
    <link rel="stylesheet" type="text/css" href="css-style.css">
    <meta charset="UTF-8">
    <title>My Profile</title>
</head>

<html lang="en">
<body>
<div class="navbar">
    <a href="myprofile">My profile</a>
    <a href="show-mentor-page.jsp">Mentor</a>
    <a href="#">Modify assignments</a>
    <a href="view">View Asgn.</a>
    <a href="userlist">List users</a>
    <a href="login">Logout</a>
</div>
<br>
<h1>Logged in with: ${email} </h1>
<h1>Answers</h1>
<table border="1">
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
</body>
</html>
