<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" %>
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
        <a href="show-mentor-page.jsp">Mentor</a>
        <a href="#">Modify assignments</a>
        <a href="view">View Asgn.</a>
        <a href="userlist">List users</a>
        <a href="add-textpage.html">Add Text Page</a>
        <a href="addtextpage">View Text Pages</a>
        <a href="attendance?date=${AttendanceService.getCurrentDate()}">Attendance</a>
        <a href="login">Logout</a>
    <br>
</div>
</body>
</html>
