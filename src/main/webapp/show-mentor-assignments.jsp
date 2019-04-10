<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.codecool.web.service.AttendanceService" %>

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
            <jsp:include page='header-mentor.jsp'>
                <jsp:param name="" value=""/>
            </jsp:include>
        </div>
        <h1>Logged in with: ${email} </h1>
        <h1>Mentor Assignments</h1>
        <br>
        <div class="assignments">
            <table class="list" border="1" border-color="white">
                <tr>
                    <th>id</th>
                    <th>Mentor id</th>
                    <th>Question</th>
                    <th>Date</th>
                    <th>Published</th>
                    <th>Max points</th>
                    <th>Do grade</th>
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
                                <form action="list-answers" method="get">
                                    <input type="hidden" name="id" value="${t.getAssignmentId()}">
                                    <input type="SUBMIT" value="Submit">
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
            </table>
        </div>
        <br>
        <form action="assignment" method="post">
            <input class="add-assignment-button" type="SUBMIT" value="Add Assignment">
        </form>
    </body>
  </html>
