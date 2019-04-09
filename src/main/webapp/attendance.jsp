<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.codecool.web.model.User" %>
<%@ page import="java.util.Arrays" %>
<%@ page import="java.util.List" %>
<%@ page import="com.codecool.web.servlet.AttendanceServlet" %>



<!DOCTYPE html>
<html>
  <head>
    <link rel="stylesheet" type="text/css" href="login.css">
  </head>
  <body>
    <div align="center">
    <form class="userprof" action="attendance" method="post">
           <input type="date" name="date"><br>
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
                            <c:when test="${param.enter=='1'}">
                                pizza.
                                <br />
                            </c:when>
                            <c:otherwise>
                                pizzas.
                                <br />
                            </c:otherwise>
                        </c:choose>
                            <input type="checkbox" name="attendance" value="${user.id}"><br>
                        </td>

                    </tr>
                </c:forEach>
            </table>
                   <input type="submit" name="submit" value="Submit">

    </form>
  </div>
  </body>
</html>
