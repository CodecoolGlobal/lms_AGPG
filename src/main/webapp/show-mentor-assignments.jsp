<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.codecool.web.service.AttendanceService" %>
<%@ page import="com.codecool.web.model.LoggedInUser" %>

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
                                    <input type="hidden" name="testId" value="${t.getAssignmentId()}">
                                    <input type="SUBMIT" value="Submit">
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
            </table>
        </div>
        <br>
        <div class="add-assignment-button">
            <form action="assignment" method="post">
                <input type="SUBMIT" value="Add Assignment">
            </form>
        </div>
    </body>
  </html>
