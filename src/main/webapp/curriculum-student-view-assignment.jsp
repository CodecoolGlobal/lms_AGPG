<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.codecool.web.model.Assignment" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <link rel="stylesheet" type="text/css" href="style.css">
        <meta charset="UTF-8">
        <title>View Assignment</title>
    </head>
    <body>
      <div class="navbar">
          <a href="showname">My profile</a>
          <a href="index.jsp">Mentor</a>
          <a href="#">Modify assignments</a>
          <a href="view">View Asgn.</a>
          <a href="userlist">List users</a>
          <a href="login">Logout</a>
        <br>
        <h1>Assignment View</h1>
        <div class="assignments">
            <h1>Assignments</h1>
            <table border="1" border-color="white">
                <tr>
                    <th>id</th>
                    <th>Question</th>
                    <th>Date</th>
                    <th>Max points</th>
                </tr>
                <c:forEach var="t" items="${assignment}">
                    <tr>
                        <td>${t.getAssignmentId()}"</td>
                        <td>${t.getQuestion()}"</td>
                        <td>${t.getDate().toString()}</td>
                        <td>${t.getMaxPoints()}</td>
                    </tr>
                </c:forEach>
            </table>

    </body>
  </html>
