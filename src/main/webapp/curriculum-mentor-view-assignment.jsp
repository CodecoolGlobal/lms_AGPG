<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.codecool.web.model.Assignment" %>
<%@ page import="com.codecool.web.model.Users" %>
<%@ page import="java.util.Arrays" %>

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
        <a href="view">Mentor View Asgn.</a>
        <a href="#">Student View Asgn.</a>
        <a href="#">View page</a>
        <a href="userlist">List users</a>
        </div>
        <br>
        <div class="assignments">
            <h1>Assignments</h1>
            <table border="1" border-color="white">
                <tr>
                    <th>id</th>
                    <th>Mentor id</th>
                    <th>Question</th>
                    <th>Date</th>
                    <th>Published</th>
                    <th>Max points</th>
                </tr>
                    <c:forEach var="t" items="${assignment}">
                        <tr>
                        <td>${t.getAssignmentId()}"</td>
                        <td>${t.getMentorID()}</td>
                        <td>${t.getQuestion()}"</td>
                        <td>${t.getDate().toString()}</td>
                        <td>${t.isPublished()}</td>
                        <td>${t.getMaxPoints()}</td>
                        </tr>
                    </c:forEach>
            </table>
        </div>
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