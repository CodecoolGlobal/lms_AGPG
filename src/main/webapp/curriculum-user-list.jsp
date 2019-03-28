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

<html lang="en">
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
    <table border="1">
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
