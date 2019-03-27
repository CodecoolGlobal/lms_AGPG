<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.codecool.web.model.User" %>
<%@ page import="com.codecool.web.model.Users" %>
<%@ page import="java.util.Arrays" %>

<!DOCTYPE html>
 <head>
    <link rel="stylesheet" type="text/css" href="style.css">
    <meta charset="UTF-8">
    <title>My Profile</title>
</head>
<body>
<html lang="en">
<table border="1">
            <tr>
                <th>ID</th>
                <th>Poster</th>
                <th>Content</th>
                <th>Date</th>
            </tr>
            <c:forEach items="${userList}" var="user">
                <tr>
                    <td>
                        ${user.fName}<br>
                    </td>
                    <td>
                        ${user.email}<br>
                    </td>
                    <td>
                        ${user.pw}<br>
                    </td>
                    <td>
                        ${user.fName}<br>
                    </td>
                </tr>
            </c:forEach>
        </table>

      <a href="curriculum.jsp">Back to menu</a>
</body>
