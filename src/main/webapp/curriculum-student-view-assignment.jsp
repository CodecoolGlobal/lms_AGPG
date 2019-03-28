<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
        <a href="curriculum-myprofile.jsp">My profile</a>
        <a href="index.jsp">Mentor</a>
        <a href="curriculum-mentor-modify-assignment.html">Modify assignments</a>
        <a href="curriculum-mentor-view-assignment.jsp">Mentor View Asgn.</a>
        <a href="curriculum-student-view-assignment.jsp">Student View Asgn.</a>
        <a href="#">View page</a>
        <a href="userlist">List users</a>
        <br>
        <h1>Assignment View</h1>
        <div class="assignments">
            <h2>Assignments</h2>
            <table border="1" border-color="white">
                <tr>
                    <th>id</th>
                    <th>Question</th>
                    <th>Date</th>
                    <th>Max points</th>
                </tr>
                    <c:forEach var="t" items="${view}">
                        <tr>
                        <td>${t.getAssignmentId()}"</td>
                        <td>${t.getQuestion()}"</td>
                        <td>${t.getDate().toString()}</td>
                        <td>${t.getMaxPoints}</td>
                        </tr>
                    </c:forEach>
            </table>

    </body>
  </html>
  <style media="screen">

  .navbar {
    width: 100%;
    overflow: auto;
  }

  .navbar a {
    float: left;
    padding: 12px;
    color: white;
    text-decoration: none;
    width: auto;
    font-size: 17px;
  }

  .navbar a:hover {
    background-color: #1a8cff;
  }

  @media screen and (max-width: 500px) {
    .navbar a {
      float: none;
      display: block;
    }
  }
  </style>
