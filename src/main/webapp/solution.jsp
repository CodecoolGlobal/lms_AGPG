<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="style.css">
    <meta charset="UTF-8">
    <title>View Assignment</title>
</head>
<body>
<div class="navbar">
    <a href="myprofile">My profile</a>
    <a href="index.jsp">Mentor</a>
    <a href="#">Modify assignments</a>
    <a href="view">View Asgn.</a>
    <a href="userlist">List users</a>
    <a href="login">Logout</a>
    <br>
    <h1>Solution View</h1>
    <h1>Logged in with: ${email} </h1>
    <h2>Id: ${assignment.assignmentId}</h2>
    <h2>${assignment.question}</h2>
    <form action="answer" method="post">
        Please enter your solution:
        <br>
        <input type="hidden" name="id" value="${assignment.assignmentId}">
            <textarea type="text" name="answer" rows="5" cols="30"></textarea>
        <br>
        <input type="SUBMIT" value="Submit">
    </form>
</div>
</body>

</html>
