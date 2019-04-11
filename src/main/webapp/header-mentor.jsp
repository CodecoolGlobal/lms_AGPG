<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="com.codecool.web.service.AttendanceService" %>
<!DOCTYPE>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="css-style.css">
    <meta charset="UTF-8">
    <title>View Assignment</title>
</head>
<body>
<div class="navbar">
        <a href="myprofile">My profile</a>
        <a href="add-assignment.jsp">Modify assignments</a>
        <a href="view">View Assignments</a>
        <a href="userlist">List users</a>
        <a href="add-textpage.jsp">Add Text Page</a>
        <a href="addtextpage">View Text Pages</a>
        <a href="attendance?date=${AttendanceService.getCurrentDate()}">Attendance</a>
        <a href="login">Logout</a>
    <br>
</div>
<h1>Logged in with: ${email} </h1>
</body>
</html>
