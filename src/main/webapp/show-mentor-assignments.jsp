<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <link rel="stylesheet" type="text/css" href="css-style.css">
        <meta charset="UTF-8">
        <title>View Assignment</title>
    </head>
    <body>
        <div class="navbar">
            <a href="myprofile">My profile</a>
            <a href="show-mentor-page.jsp">Mentor</a>
            <a href="#">Modify assignments</a>
            <a href="view">View Asgn.</a>
            <a href="userlist">List users</a>
            <a href="add-textpage.html">Add Text Page</a>
            <a href="addtextpage">View Text Pages</a>
            <a href="login">Logout</a>
        </div>
        <br>
        <h1>Logged in with: ${email} </h1>
        <h1>Assignments</h1>
        <div class="assignments">

            <table border="1" border-color="white">
                <tr>
                    <th>id</th>
                    <th>Mentor id</th>
                    <th>Question</th>
                    <th>Date</th>
                    <th>Published</th>
                    <th>Max points</th>
                    <th>Grade</th>
                </tr>
                    <c:forEach var="t" items="${assignment}">
                        <tr>
                            <td>${t.getAssignmentId()}</td>
                            <td>${t.getMentorID()}</td>
                            <td>${t.getQuestion()}</td>
                            <td>${t.getDate().toString()}</td>
                            <td>${t.isPublished()}</td>
                            <td>${t.getMaxPoints()}</td>
                            <td>
                                <form action="list-answers" method="post">
                                    <input type="">
                                    <input type="hidden" name="id" value="${t.assignmentId}">
                                    <input type="SUBMIT" value="Submit">
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
            </table>
        </div>
    </body>
  </html>
