<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.codecool.web.model.User" %>
<%@ page import="java.util.Arrays" %>
<%@ page import="java.util.List" %>
<%@ page import="com.codecool.web.servlet.AttendanceServlet" %>



<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="css-login.css">
    </head>
    <body>
    <div class="navbar">
        <jsp:include page='header-mentor.jsp'>
            <jsp:param name="" value=""/>
        </jsp:include>
    </div>
    <h1>Logged in with: ${email} </h1>
    <h1>Attendance</h1>
        <div align="center">
            <h2>${middleDate}</h2>
            <form class="userprof" action="attendance" method="post">
                <table class="list" border="1">
                    <tr>
                        <th>User</th>
                        <th>Present</th>
                    </tr>
                    <c:forEach items="${userList}" var="user">
                        <tr>
                            <td>
                                ${user.fName}<br>
                            </td>
                            <td>
                            <c:choose>
                                <c:when test="${user.isPresent()}">
                                    <input type="checkbox" name="attendance" value="${user.id}" checked><br>
                                </c:when>
                                <c:otherwise>
                                    <input type="checkbox" name="attendance" value="${user.id}"><br>
                                </c:otherwise>
                            </c:choose>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
                <br>
                <input type="submit" name="submit" value="Submit">
            </form>
        </div>
    </body>
</html>
