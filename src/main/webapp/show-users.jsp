<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.codecool.web.model.User" %>
<%@ page import="java.util.Arrays" %>

<!DOCTYPE html>
 <head>
    <link rel="stylesheet" type="text/css" href="css-style.css">
    <meta charset="UTF-8">
    <title>My Profile</title>
</head>

<html lang="en">
    <body>
        <div class="navbar">
            <jsp:include page='header-mentor.jsp'>
                <jsp:param name="" value=""/>
            </jsp:include>
        </div>
      <h1>Logged in with: ${email} </h1>
      <h1>Users</h1>
        <br>
    <table class="list" border="1">
        <tr>
            <th>ID</th>
            <th>User</th>
            <th>Email</th>
            <th>isMentor</th>
        </tr>
            <c:forEach items="${userList}" var="user">
                <tr>
                    <td>
                        ${user.id}<br>
                    </td>
                    <td>
                        ${user.fName}<br>
                    </td>
                    <td>
                        ${user.email}<br>
                    </td>
                    <td>
                        ${user.mentor}<br>
                    </td>
                </tr>
            </c:forEach>
        </table>
</body>
</html>
