<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.codecool.web.model.User" %>
<%@ page import="java.util.Arrays" %>
<%@ page import="java.util.List" %>
<%@ page import="com.codecool.web.servlet.AttendanceServlet" %>
<%@ page import="com.codecool.web.service.AttendanceService" %>
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
    <h1>Attendance</h1>
        <div align="center">
            <table>
                <tr>
                    <td>
                        <a href="attendance?date=${backInTimeMonth}">Back one Month</a>
                    </td>
                    <td>
                        <a href="attendance?date=${backInTimeWeek}">Back one Week</a>
                    </td>
                    <td>
                        <a href="attendance?date=${backInTimeDay}">Back one Day</a>
                    </td>
                    <td>
                        <h2>${middleDate}</h2>
                    </td>
                    <td>
                        <a href="attendance?date=${AttendanceService.getCurrentDate()}">Back to Current Date</a>
                    </td>
                </tr>

            </table>
            <form class="userprof" action="attendance" method="post">
                <input type="hidden" name="hiddenDate" value="${middleDate}">
                <table border="1">
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
